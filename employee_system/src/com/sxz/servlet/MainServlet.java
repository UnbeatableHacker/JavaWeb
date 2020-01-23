/**
 * Project Name:employee_system
 * File Name:MainServlet.java
 * Package Name:com.sxz.servlet
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.sxz.entity.Department;
import com.sxz.entity.Employee;
import com.sxz.entity.User;
import com.sxz.service.DeptService;
import com.sxz.service.EmpService;
import com.sxz.service.UserService;
import com.sxz.serviceImpl.DeptServiceImpl;
import com.sxz.serviceImpl.EmpServiceImpl;
import com.sxz.serviceImpl.UserServiceImpl;
import com.sxz.utils.PageUtil;

/**
 * Description: 负责请求分发,以.dao结尾的请求来了都找这个Servlet<br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class MainServlet extends HttpServlet {

    EmpService empservice = new EmpServiceImpl();

    DeptService deptservice = new DeptServiceImpl();

    UserService userservice = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取请求地址
        String path = request.getServletPath();

        if ("/login.do".equals(path)) { // 登录
            login(request, response);

        } else if ("/register.do".equals(path)) { // 注册
            register(request, response);

        } else if ("/logout.do".equals(path)) { // 退出
            logout(request, response);

        } else if ("/queryEmpAll.do".equals(path)) { // 列表显示员工
            queryEmpAll(request, response);

        } else if ("/insertEmp.do".equals(path)) { // 添加员工信息
            insertEmp(request, response);

        } else if ("/deleteEmp.do".equals(path)) { // 删除员工信息
            deleteEmp(request, response);

        } else if ("/deleteMore.do".equals(path)) { // 批删
            deleteMore(request, response);

        } else if ("/updateEmp.do".equals(path)) { // 更改员工信息
            updateEmp(request, response);

        } else if ("/queryEmpById.do".equals(path)) { // 修改回显员工信息
            queryEmpById(request, response);

        } else if ("/toAddEmp.do".equals(path)) { // 跳转添加页面
            toAddEmp(request, response);

        } else if ("/savaOrUpdateEmp.do".equals(path)) {
            savaOrUpdateEmp(request, response);

        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session2 = request.getSession();
        session2.invalidate();
        response.sendRedirect("login.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flg = userservice.register(user);

        if (flg) {
            response.sendRedirect("login.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(null, username, password, null);
        boolean flg = userservice.login(user, session);

        if (flg) {
            response.sendRedirect("queryEmpAll.do");
        }
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String empno = request.getParameter("empno");
        boolean flg = empservice.deleteEmp(empno);
        if (flg) {
            response.sendRedirect("queryEmpAll.do");
        }
    }

    private void deleteMore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] strings = request.getParameterValues("empno");
        String ids = String.join(",", strings);
        boolean flg = empservice.deletMore(ids);

        if (flg) {
            response.sendRedirect("queryEmpAll.do");
        }
    }

    private void savaOrUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();

        String[] strings = request.getParameterValues("hobby");
        String hobby = String.join(",", strings);

        Employee emp = new Employee();
        try {
            // 将map集合转为Java对象
            BeanUtils.populate(emp, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emp.setHobby(hobby);

        boolean flg = empservice.savaOrUpdateEmp(emp);
        if (flg) {
            // 转发到列表页面
            response.sendRedirect("queryEmpAll.do");
        }
    }

    private void updateEmp(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Map<String, String[]> map = request.getParameterMap();

        String[] strings = request.getParameterValues("hobby");
        String hobby = String.join(",", strings);

        Employee emp = new Employee();
        try {
            // 将map集合转为Java对象
            BeanUtils.populate(emp, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emp.setHobby(hobby);

        boolean flg = empservice.updateEmp(emp);
        if (flg) {
            // 转发到列表页面
            response.sendRedirect("queryEmpAll.do");
        } else {
            request.getRequestDispatcher("update_emp.jsp").forward(request, response);
        }
    }

    private void queryEmpById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empno = request.getParameter("empno");
        // 根据id查询信息进行回显
        Employee emp = empservice.queryEmpById(empno);
        // 查询上级领导
        List<Employee> leaderAll = empservice.queryDeptAllBySid();
        // 查询部门
        List<Department> deptAll = deptservice.queryDeptAll();
        request.setAttribute("emp", emp);
        request.setAttribute("leaderAll", leaderAll);
        request.setAttribute("deptAll", deptAll);
        // 转发
        request.getRequestDispatcher("update_emp.jsp").forward(request, response);
    }

    private void insertEmp(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Map<String, String[]> map = request.getParameterMap();

        String[] strings = request.getParameterValues("hobby");
        String hobby = String.join(",", strings);

        Employee emp = new Employee();
        try {
            // 将map集合转为Java对象
            BeanUtils.populate(emp, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emp.setHobby(hobby);

        boolean flg = empservice.inserEmp(emp);
        if (flg) {
            response.sendRedirect("queryEmpAll.do");
        } else {
            request.getRequestDispatcher("add_emp.jsp").forward(request, response);
        }
    }

    private void toAddEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();
        // 查询上级领导
        List<Employee> empAll = empservice.queryDeptAllBySid();
        // 查询部门
        List<Department> deptAll = deptservice.queryDeptAll();

        map.put("empAll", empAll);
        map.put("deptAll", deptAll);

        request.setAttribute("map", map);

        request.getRequestDispatcher("add_emp.jsp").forward(request, response);
    }

    private void queryEmpAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 列表分页
        String num = request.getParameter("pageNum");

        // 模糊查询
        String empname = request.getParameter("empname");
        String deptno = request.getParameter("deptno");

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", num);

        map.put("empname", empname);
        map.put("deptno", deptno);
        // 获得员工列表
        PageUtil page = empservice.queryEmpAll(map);
        // 查询部门信息（下拉列表）
        List<Department> deptAll = deptservice.queryDeptAll();
        // 将查询到的结果放到request作用域中
        // 使用map集合存储原始数据

        // map.put("empAll", empAll);
        map.put("deptAll", deptAll);
        map.put("page", page);
        // 将map放到request作用域中
        request.setAttribute("map", map);
        // 通过转发将数据带到emp_list.jsp页面
        request.getRequestDispatcher("emp_list.jsp").forward(request, response);
    }
}

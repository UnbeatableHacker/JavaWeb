/**
 * Project Name:employee_system
 * File Name:EmpServiceImpl.java
 * Package Name:com.sxz.serviceimpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.serviceImpl;

import java.util.HashMap;
import java.util.List;

import com.sxz.dao.EmpDao;
import com.sxz.daoImpl.EmpDaoImpl;
import com.sxz.entity.Employee;
import com.sxz.service.EmpService;
import com.sxz.utils.PageUtil;

/**
 * Description: employee业务层 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class EmpServiceImpl implements EmpService {

    EmpDao dao = new EmpDaoImpl();

    @Override
    public PageUtil queryEmpAll(HashMap<String, Object> map) {
        int pageNum = 1;
        // 获取当前页
        Object num = map.get("pageNum");
        if (num != null) {
            // 将object转化为int
            pageNum = Integer.parseInt(num + "");
        }
        int totalRecords = dao.getTotalRecords();
        PageUtil page = new PageUtil(totalRecords, pageNum);
        map.put("startIndex", page.getStartIndex());
        map.put("pageSize", page.getPageSize());
        List<Employee> list = dao.queryEmpAll(map);
        // 将分页数据封装到工具类中
        page.setList(list);
        return page;

    }

    @Override
    public List<Employee> queryDeptAllBySid() {
        return dao.queryDeptAllBySid();
    }

    @Override
    public boolean inserEmp(Employee emp) {
        boolean num = dao.inserEmp(emp);
        return false;
    }

    @Override
    public Employee queryEmpById(String empno) {
        return dao.queryEmpById(empno);
    }

    @Override
    public boolean updateEmp(Employee emp) {

        return dao.updateEmp(emp);
    }

    @Override
    public boolean savaOrUpdateEmp(Employee emp) {

        if (emp.getEmpno() != null) { // 不是空，则为修改
            return dao.updateEmp(emp);
        } else {
            return dao.inserEmp(emp);
        }

    }

    @Override
    public boolean deleteEmp(String empno) {

        return dao.deleteEmp(empno);
    }

    @Override
    public boolean deletMore(String ids) {

        return dao.deletMore(ids);
    }

}

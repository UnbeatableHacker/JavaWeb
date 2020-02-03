/**
 * Project Name:employee_system
 * File Name:EmpDaoImpl.java
 * Package Name:com.sxz.daoImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.daoImpl;

import java.util.HashMap;
import java.util.List;

import com.sxz.dao.EmpDao;
import com.sxz.entity.Employee;
import com.sxz.utils.JDBCUtil;

/**
 * Description: employee持久层<br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class EmpDaoImpl implements EmpDao {

    /**
     * 
     * 员工列表显示
     * 
     * @see com.sxz.dao.EmpDao#queryEmpAll()
     */
    @Override
    public List<Employee> queryEmpAll(HashMap<String, Object> map) {
        String sql = "SELECT e.*,(select empname from employee e2 where e2.empno=e.sid) as leader,d.`deptname` FROM employee e INNER JOIN department d ON e.`deptno`=d.`deptno` where 1=1";
        // 根据姓名查询
        if (map.get("empname") != null && !"".equals((map.get("empname") + "").trim())) {
            sql += " and e.empname like '%" + map.get("empname") + "%'";
        }
        // 根据部门查询
        if (map.get("deptno") != null && Integer.parseInt(map.get("deptno") + "") != 0) {
            sql += " and e.deptno=" + map.get("deptno");
        }

        sql += " limit ?,?;";
        List<Employee> list = JDBCUtil.getList(Employee.class, sql, map.get("startIndex"), map.get("pageSize"));
        return list;
    }

    /**
     * 
     * 查询总记录数
     * 
     * @see com.sxz.dao.EmpDao#getTotalRecords()
     */
    @Override
    public int getTotalRecords() {
        Integer count = JDBCUtil.getCount("select count(*) from employee");
        return count;
    }

    @Override
    public List<Employee> queryDeptAllBySid() {
        List<Employee> list = JDBCUtil.getList(Employee.class, "select * from employee");
        return list;
    }

    @Override
    public boolean inserEmp(Employee emp) {
        String sql = "insert into employee(empname,empsex,job,hiredate,salary,sid,deptno,hobby) values (?,?,?,?,?,?,?,?)";
        boolean dml = JDBCUtil.getDML(sql, emp.getEmpname(), emp.getEmpsex(), emp.getJob(), emp.getHiredate(),
                emp.getSalary(), emp.getSid(), emp.getDeptno(), emp.getHobby());
        return dml;
    }

    @Override
    public Employee queryEmpById(String empno) {
        String sql = "select * from employee where empno=?";
        Employee employee = JDBCUtil.getOneObject(Employee.class, sql, empno);
        return employee;
    }

    @Override
    public boolean updateEmp(Employee emp) {
        String sql = "update employee set empname=?,empsex=?,job=?,hiredate=?,salary=?,sid=?,deptno=?,hobby=? where empno=?";
        boolean dml = JDBCUtil.getDML(sql, emp.getEmpname(), emp.getEmpsex(), emp.getJob(), emp.getHiredate(),
                emp.getSalary(), emp.getSid(), emp.getDeptno(), emp.getHobby(), emp.getEmpno());
        return dml;
    }

    @Override
    public boolean deleteEmp(String empno) {
        String sql = "delete from employee where empno=?";
        boolean dml = JDBCUtil.getDML(sql, empno);
        return dml;
    }

    @Override
    public boolean deletMore(String ids) {
        String sql = "delete from employee where empno in (" + ids + ")";
        boolean dml = JDBCUtil.getDML(sql);
        return dml;
    }

}

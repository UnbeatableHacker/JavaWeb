/**
 * Project Name:employee_system
 * File Name:Empdao.java
 * Package Name:com.sxz.dao
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.dao;

import java.util.HashMap;
import java.util.List;

import com.sxz.entity.Employee;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface EmpDao {
    public List<Employee> queryEmpAll(HashMap<String, Object> map);

    public int getTotalRecords();

    public List<Employee> queryDeptAllBySid();

    public boolean inserEmp(Employee emp);

    public Employee queryEmpById(String empno);

    public boolean updateEmp(Employee emp);

    public boolean deleteEmp(String empno);

    public boolean deletMore(String ids);

}

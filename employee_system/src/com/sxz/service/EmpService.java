/**
 * Project Name:employee_system
 * File Name:EmpService.java
 * Package Name:com.sxz.service
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.service;

import java.util.HashMap;
import java.util.List;

import com.sxz.entity.Employee;
import com.sxz.utils.PageUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface EmpService {
    public PageUtil queryEmpAll(HashMap<String, Object> map);

    public List<Employee> queryDeptAllBySid();

    public boolean inserEmp(Employee emp);

    public Employee queryEmpById(String empno);

    public boolean updateEmp(Employee emp);

    public boolean savaOrUpdateEmp(Employee emp);

    public boolean deleteEmp(String empno);

    public boolean deletMore(String ids);
}

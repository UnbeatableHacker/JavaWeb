/**
 * Project Name:employee_system
 * File Name:DeptDao.java
 * Package Name:com.sxz.dao
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.dao;

import java.util.List;

import com.sxz.entity.Department;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface DeptDao {
    public List<Department> queryDeptAll();
}

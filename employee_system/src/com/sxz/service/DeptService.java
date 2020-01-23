/**
 * Project Name:employee_system
 * File Name:DeptService.java
 * Package Name:com.sxz.service
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.service;

import java.util.List;

import com.sxz.entity.Department;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface DeptService {
    public List<Department> queryDeptAll();
}

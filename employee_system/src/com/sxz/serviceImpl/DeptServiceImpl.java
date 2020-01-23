/**
 * Project Name:employee_system
 * File Name:DeptServiceImpl.java
 * Package Name:com.sxz.serviceImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.serviceImpl;

import java.util.List;

import com.sxz.dao.DeptDao;
import com.sxz.daoImpl.DeptDaoImpl;
import com.sxz.entity.Department;
import com.sxz.service.DeptService;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class DeptServiceImpl implements DeptService {

    DeptDao dept = new DeptDaoImpl();

    @Override
    public List<Department> queryDeptAll() {
        return dept.queryDeptAll();
    }

}

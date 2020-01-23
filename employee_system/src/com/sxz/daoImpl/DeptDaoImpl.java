/**
 * Project Name:employee_system
 * File Name:DeptDaoImpl.java
 * Package Name:com.sxz.daoImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.daoImpl;

import java.util.List;

import com.sxz.dao.DeptDao;
import com.sxz.entity.Department;
import com.sxz.utils.JDBCUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class DeptDaoImpl implements DeptDao {

    @Override
    public List<Department> queryDeptAll() {

        String sql = "select * from department";
        List<Department> list = JDBCUtil.getList(Department.class, sql);
        return list;
    }

}

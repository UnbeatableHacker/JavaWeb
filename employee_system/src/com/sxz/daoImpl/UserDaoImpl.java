/**
 * Project Name:employee_system
 * File Name:UserDaoImpl.java
 * Package Name:com.sxz.daoImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.daoImpl;

import com.sxz.dao.UserDao;
import com.sxz.entity.User;
import com.sxz.utils.JDBCUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean register(User user) {
        String sql = "insert into User(usernam,password,email) value(?,?,?)";
        boolean dml = JDBCUtil.getDML(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return dml;
    }

    @Override
    public User login(User user) {
        String sql = "select * from User where username=? and password=?";
        User u = JDBCUtil.getOneObject(User.class, sql, user.getUsername(), user.getPassword());
        return u;
    }

}

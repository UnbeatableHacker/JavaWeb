/**
 * Project Name:LibraryManagementSystem
 * File Name:UserDaoImpl.java
 * Package Name:com.sxz.daoImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.daoImpl;

import com.sxz.entity.User;
import com.sxz.utils.JDBCUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @param <T>
 * @see
 */
public class UserDaoImpl {

    public boolean userRegister(User user) {
        String sql = "insert user(userName,password,college,sex) value (?,?,?,?)";
        boolean flg = JDBCUtil.getDML(sql, user.getUserName(), user.getPassword(), user.getCollege(), user.getSex());
        return flg;
    }

    public User userLogin(String userId, String password) {
        String sql = "select * from user where userId=? and password=?";
        User user = JDBCUtil.getOneObject(User.class, sql, userId, password);
        return user;
    }

    public boolean addNum(String userId) {
        String sql = "select * from user where userId=?";
        User user = JDBCUtil.getOneObject(User.class, sql, userId);
        int borrowNum = user.getBorrowNum();
        int borrowingNum = user.getBorrowingNum();

        sql = "UPDATE `user` SET borrowNum=?,borrowingNum=? WHERE userId=?";
        boolean dml = JDBCUtil.getDML(sql, borrowNum + 1, borrowingNum + 1, userId);

        return dml;
    }

    public boolean userCancellation(String userId) {
        String sql = "delete from user where userId=?";
        boolean dml = JDBCUtil.getDML(sql, userId);
        return dml;
    }

    public boolean deleteNum(String userId) {
        String sql = "select * from user where userId=?";
        User user = JDBCUtil.getOneObject(User.class, sql, userId);
        int borrowingNum = user.getBorrowingNum();

        sql = "UPDATE `user` SET borrowingNum=? WHERE userId=?";
        boolean dml = JDBCUtil.getDML(sql, borrowingNum - 1, userId);

        return dml;
    }

}

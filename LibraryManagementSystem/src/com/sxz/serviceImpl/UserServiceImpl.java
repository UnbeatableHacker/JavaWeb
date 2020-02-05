/**
 * Project Name:LibraryManagementSystem
 * File Name:UserServiceImpl.java
 * Package Name:com.sxz.serviceImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.serviceImpl;

import javax.servlet.http.HttpSession;

import com.sxz.daoImpl.UserDaoImpl;
import com.sxz.entity.Student;
import com.sxz.entity.Teacher;
import com.sxz.entity.User;
import com.sxz.utils.JDBCUtil;
import com.sxz.utils.MD5;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class UserServiceImpl {

    UserDaoImpl userDao = new UserDaoImpl();

    public boolean userRegister_student(String userId, String password) {
        try {
            password = MD5.reEncryption(password, password, 3);
            // '123456'加密3次后的密文为‘8c3cdd8b462aaf3bb8c7922c6553bc7e’
        } catch (Exception e) {
            e.printStackTrace();
        }

        User object = JDBCUtil.getOneObject(User.class, "select * from user where userId=?", userId);
        if (object == null) {
            String sql = "select * from student where stuId=?";
            Student student = JDBCUtil.getOneObject(Student.class, sql, userId);

            // 找到对象后,提取对象信息封装到 user 中
            // user的信息：userName，password，college，sex
            User user = new User();
            user.setUserName(student.getStuName());
            user.setPassword(password);
            user.setCollege(student.getCollege());
            user.setSex(student.getSex());

            return userDao.userRegister(user);
        }
        return false;
    }

    public boolean userRegister_teacher(String userId, String password) {
        try {
            password = MD5.reEncryption(password, password, 3);
            // '123456'加密3次后的密文为‘8c3cdd8b462aaf3bb8c7922c6553bc7e’
        } catch (Exception e) {
            e.printStackTrace();
        }

        User object = JDBCUtil.getOneObject(User.class, "select * from User where userId=?", userId);
        if (object == null) {
            String sql = "select * from teacher where teacherId=?";
            Teacher teacher = JDBCUtil.getOneObject(Teacher.class, sql, userId);

            // 找到对象后,提取对象信息封装到 user 中
            // user的信息：userName，password，college，sex
            User user = new User();
            user.setUserName(teacher.getTeacherName());
            user.setPassword(password);
            user.setCollege(teacher.getCollege());
            user.setSex(teacher.getSex());

            return userDao.userRegister(user);
        }
        return false;
    }

    public boolean userLogin(String userId, String password, HttpSession session) {
        try {
            password = MD5.reEncryption(password, password, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userDao.userLogin(userId, password);
        if (user != null) {
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    public boolean userCancellation(String userId, String password) {
        String sql = "select * from  user where userId=? and password=?;";
        try {
            password = MD5.reEncryption(password, password, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = JDBCUtil.getOneObject(User.class, sql, userId, password);
        if (user.getBorrowingNum() != 0) {
            System.out.println("抱歉，您有书未归还不能注销");
            return false;
        }
        boolean flag = userDao.userCancellation(userId);
        return flag;
    }

}

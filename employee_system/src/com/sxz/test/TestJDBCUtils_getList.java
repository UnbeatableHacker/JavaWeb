/**
 * Project Name:employee_system
 * File Name:TestJDBCUtils.java
 * Package Name:com.sxz.test
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.test;

import java.util.List;

import com.sxz.entity.User;
import com.sxz.utils.JDBCUtil;

/**
 * Description: 测试JDBCUtils <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class TestJDBCUtils_getList {
    public static void main(String[] args) {
        String sql = "SELECT * FROM USER;";
        List<User> list = JDBCUtil.getList(User.class, sql);
        for (User user : list) {
            System.out.println(user);
        }
    }
}

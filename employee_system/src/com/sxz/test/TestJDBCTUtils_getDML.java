/**
 * Project Name:employee_system
 * File Name:TestJDBCTUtils_getDML.java
 * Package Name:com.sxz.test
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.test;

import com.sxz.entity.User;
import com.sxz.utils.JDBCUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class TestJDBCTUtils_getDML {
    public static void main(String[] args) {
        User user = new User(null, "王五", "123", "1134567890@qq.com");
        String sql = "insert into user(username,password,email) value(?,?,?)";
        boolean dml = JDBCUtil.getDML(sql, user.getUsername(), user.getPassword(), user.getEmail());
        System.out.println(dml);
    }
}

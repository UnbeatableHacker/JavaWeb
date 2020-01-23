/**
 * Project Name:employee_system
 * File Name:testJDBCUtils_getOneObject.java
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
public class testJDBCUtils_getOneObject {

    public static void main(String[] args) {
        String sql = "select * from user where uid=?";
        User user = JDBCUtil.getOneObject(User.class, sql, 1);
        System.out.println(user);
    }
}

/**
 * Project Name:LibraryManagementSystem
 * File Name:Test_MD5.java
 * Package Name:com.sxz.test
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.test;

import com.sxz.utils.MD5;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Test_MD5 {
    public static void main(String[] args) {
        String password = "123456";
        try {
            password = MD5.reEncryption(password, password, 3);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

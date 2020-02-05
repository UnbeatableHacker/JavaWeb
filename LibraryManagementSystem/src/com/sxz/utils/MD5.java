/**
 * Project Name:ͨLibraryManagementSystem
 * File Name:md5.java
 * Package Name:cn.java.utils
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.sxz.utils;

import java.security.MessageDigest;

/**
 * Description: MD5加密<br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class MD5 {

    private static String[] digitals = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f" };

    /**
     * 
     * Description: 一次加密<br/>
     *
     * @author songXZ
     * @param password
     * @return
     * @throws Exception
     */
    public static String encryption(String password) throws Exception {
        String result = "";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(password.getBytes("utf-8"));
        for (int i = 0; i < bytes.length; i++) {
            int number = bytes[i];
            if (number < 0) {
                number += 256;
            }
            int k = number / 16;
            int m = number % 16;
            result += digitals[k] + digitals[m];
        }
        return result;
    }

    /**
     * 
     * Description: 二次加密<br/>
     *
     * @author songXZ
     * @param password
     * @return
     * @throws Exception
     */
    public static String reEncryption(String password) throws Exception {
        String ciphertext = encryption(encryption(password));
        return ciphertext;
    }

    /**
     * 
     * Description: 按指定文本二次加密<br/>
     *
     * @author songXZ
     * @param password
     * @param text
     * @return
     * @throws Exception
     */
    public static String reEncryption(String password, String text) throws Exception {
        String ciphertext = encryption(encryption(password) + text);
        return ciphertext;
    }

    /**
     * 
     * Description: 按指定文本加密指定次数<br/>
     *
     * @author songXZ
     * @param password
     * @param text
     * @param times
     * @return
     * @throws Exception
     */
    public static String reEncryption(String password, String text, int times) throws Exception {
        String ciphertext = encryption(password);
        for (int i = 0; i < times; i++) {
            ciphertext = encryption(ciphertext + text);
        }
        return ciphertext;
    }
}

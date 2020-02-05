/**
 * Project Name:LibraryManagementSystem
 * File Name:Administrator.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

import com.sxz.utils.MD5;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Administrator {
    private Integer admId;

    private String admName;

    private String password;

    public Administrator() {

    }

    public Administrator(String admName, String password) {
        setPassword(password);
        this.admName = admName;
        this.password = getPassword();
    }

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        MD5 md5 = new MD5();
        try {
            this.password = md5.reEncryption(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Administrator [admId=" + admId + ", admName=" + admName + ", password=" + password + "]";
    }

}

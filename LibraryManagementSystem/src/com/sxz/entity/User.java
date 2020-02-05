/**
 * Project Name:LibraryManagementSystem
 * File Name:User.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

import com.sxz.utils.MD5;

/**
 * Description: 用户类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String college;

    private int sex;

    private int borrowNum;

    private int borrowingNum;

    public User() {

    }

    public User(String userName, String password, String college, int sex, int borrowNum, int borrowingNum) {
        setPassword(password);
        this.userName = userName;
        this.password = getPassword();
        this.college = college;
        this.sex = sex;
        this.borrowNum = borrowNum;
        this.borrowingNum = borrowingNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(int borrowNum) {
        this.borrowNum = borrowNum;
    }

    public int getBorrowingNum() {
        return borrowingNum;
    }

    public void setBorrowingNum(int borrowingNum) {
        this.borrowingNum = borrowingNum;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", college=" + college
                + ", sex=" + sex + ", borrowNum=" + borrowNum + ", borrowingNum=" + borrowingNum + "]";
    }

}

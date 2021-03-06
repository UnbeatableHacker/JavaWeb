/**
 * Project Name:employee_system
 * File Name:User.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: 用户类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class User {
    private Integer uid;

    private String username;

    private String password;

    private String email;

    public User() {
        super();
    }

    public User(Integer uid, String userName, String password, String email) {
        super();
        this.uid = uid;
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}

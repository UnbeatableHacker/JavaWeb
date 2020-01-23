/**
 * Project Name:employee_system
 * File Name:UserService.java
 * Package Name:com.sxz.service
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.service;

import javax.servlet.http.HttpSession;

import com.sxz.entity.User;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface UserService {
    public boolean register(User user);

    public boolean login(User user, HttpSession session);

}

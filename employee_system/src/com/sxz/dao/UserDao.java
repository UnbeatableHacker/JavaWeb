/**
 * Project Name:employee_system
 * File Name:UserDao.java
 * Package Name:com.sxz.dao
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.dao;

import com.sxz.entity.User;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public interface UserDao {

    public boolean register(User user);

    public User login(User user);

}

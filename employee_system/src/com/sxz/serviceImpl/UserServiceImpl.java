/**
 * Project Name:employee_system
 * File Name:UserServiceImpl.java
 * Package Name:com.sxz.serviceImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.serviceImpl;

import javax.servlet.http.HttpSession;

import com.sxz.dao.UserDao;
import com.sxz.daoImpl.UserDaoImpl;
import com.sxz.entity.User;
import com.sxz.service.UserService;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public boolean register(User user) {

        return dao.register(user);
    }

    @Override
    public boolean login(User user, HttpSession session) {

        User u = dao.login(user);
        if (u != null) {
            // 将用户登录信息存放到session中
            session.setAttribute("user", u);
            return true;
        }
        return false;
    }

}

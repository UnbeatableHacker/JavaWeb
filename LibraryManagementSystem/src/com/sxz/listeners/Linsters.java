/**
 * Project Name:employee_system
 * File Name:Linsters.java
 * Package Name:com.sxz.listener
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Description: 监听器: 实现在线人数监控 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Linsters implements HttpSessionListener {

    private int userNumber; // 在线用户数量

    /**
     * 
     * 打开浏览器在线用户增加.
     * 
     * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.setAttribute("userNumber", userNumber++);
    }

    /**
     * 
     * 关闭浏览器在线人数减少.
     * 
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.setAttribute("userNumber", userNumber--);
    }

}

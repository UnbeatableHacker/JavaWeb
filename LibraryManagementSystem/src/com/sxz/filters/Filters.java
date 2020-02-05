/**
 * Project Name:employee_system
 * File Name:Filters.java
 * Package Name:com.sxz.filter
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description: 过滤器: 实现请求响应编码处理 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Filters implements Filter {

    /**
     * 
     * destroy用于销毁.
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 处理请求与响应编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // chain是放行
        chain.doFilter(request, response);
    }

    /**
     * 
     * init用于初始化.
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("初始化");
    }

}

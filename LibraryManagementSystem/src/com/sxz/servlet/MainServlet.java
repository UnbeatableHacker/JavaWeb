/**
 * Project Name:LibraryManagementSystem
 * File Name:MainServlet.java
 * Package Name:com.sxz.servlet
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.sxz.entity.Book;
import com.sxz.serviceImpl.BookServiceImpl;
import com.sxz.serviceImpl.UserServiceImpl;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookServiceImpl bookService = new BookServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        String path = request.getServletPath();

        // 查找图书 -- 完成
        if ("/lookupBooks.do".equals(path)) {
            HttpSession session = request.getSession();
            // 获取参数
            String bookName = request.getParameter("bookName");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            List<Book> books = bookService.lookupBooks(bookName, author, publisher);

            // request.setAttribute("books", books);
            session.setAttribute("books", books);
            // 页面转发至图书显示页面
            request.getRequestDispatcher("bookList.jsp").forward(request, response);

            // 借阅图书 -- 完成
        } else if ("/borrowBook.do".equals(path)) {
            String bookId = request.getParameter("bookId");
            String userId = request.getParameter("userId");
            // 此时确定已有bookId，userId
            Boolean flag = false;
            flag = bookService.borrowBook(bookId, userId);

            if (flag)
                System.out.println("借书成功");
            else
                System.out.println("借书失败");

            request.getRequestDispatcher("lookupBook").forward(request, response);

            // 归还图书
        } else if ("/returnBook.do".equals(path)) {
            String bookId = request.getParameter("bookId");
            String userId = request.getParameter("userId");

            boolean flag = bookService.returnBook(bookId, userId);

            if (flag) {
                System.out.println("还书成功");
            } else {
                System.out.println("还书失败");
            }

            response.sendRedirect("returnBook.jsp");

            // 添加图书(默认管理员)
        } else if ("/addBook.do".equals(path)) {
            Map<String, String[]> bookParameter = request.getParameterMap();
            Book book = new Book();
            try {
                // 将map集合转为Java对象
                BeanUtils.populate(book, bookParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 删除图书(默认管理员)
        } else if ("/delectBook.do".equals(path)) {
            Map<String, String[]> map = request.getParameterMap();
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            String bookId = null;
            String admId = null;
            String password = null;
            while (it.hasNext()) {
                bookId = it.next();
                admId = it.next();
                password = it.next();
            }
            System.out.println("bookId=" + bookId);
            System.out.println("admId=" + admId);
            System.out.println("password=" + password);

            response.sendRedirect("delectBook.jsp");
            // 用户登录 -- 完成
        } else if ("/userLogin.do".equals(path)) {
            userLogin(request, response, userService);

            // 用户注册 -- 未全部完成,没有判断是否已经注册
        } else if ("/userRegister.do".equals(path)) {
            userRegister(request, response, userService);

            // 用户注销
        } else if ("/userCancellation.do".equals(path)) {
            userCancellation(request, response, userService);

            // 管理员注册 -- 未实现
        } else if ("/administratorsRegister.do".equals(path)) {

            // 管理员注销 -- 未实现
        } else if ("/ .do".equals(path)) {

            // 退出系统 -- 成功
        } else if ("/exitSystem.do".equals(path)) {
            exitSystem(request, response);
        }

    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response, UserServiceImpl userService)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 接受数据
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        boolean flg = false;
        flg = userService.userLogin(userId, password, session);

        if (flg) {
            System.out.println("登录成功");
            if (session.getAttribute("books") != null) {
                request.getRequestDispatcher("bookList.jsp").forward(request, response);
            } else
                request.getRequestDispatcher("lookupBook.jsp").forward(request, response);
        } else {
            System.out.println("登录失败");
        }
    }

    private void userRegister(HttpServletRequest request, HttpServletResponse response, UserServiceImpl userService)
            throws IOException {
        // 接受数据
        String identity = request.getParameter("identity");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        boolean flg = false;
        if ("student".equals(identity)) {
            flg = userService.userRegister_student(userId, password);
        } else if ("teacher".equals(identity)) {
            flg = userService.userRegister_teacher(userId, password);
        }

        if (flg) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }

        response.sendRedirect("lookupBook.jsp");
    }

    private void userCancellation(HttpServletRequest request, HttpServletResponse response, UserServiceImpl userService)
            throws IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        boolean flag = userService.userCancellation(userId, password);

        if (flag) {
            System.out.println("注销成功");
            // 页面重定向
            response.sendRedirect("lookupBook.jsp");
        } else {
            response.sendRedirect("userCancellation.jsp");
            System.out.println("注销失败");
        }
    }

    private void exitSystem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("lookupBook.jsp");
    }

}

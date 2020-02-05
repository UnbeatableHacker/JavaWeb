/**
 * Project Name:LibraryManagementSystem
 * File Name:bookServiceImpl.java
 * Package Name:com.sxz.serviceImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.serviceImpl;

import java.util.List;

import com.sxz.daoImpl.BookDaoImpl;
import com.sxz.daoImpl.UserDaoImpl;
import com.sxz.entity.Book;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class BookServiceImpl {

    BookDaoImpl bookDao = new BookDaoImpl();

    UserDaoImpl userDao = new UserDaoImpl();

    public List<Book> lookupBooks(String bookName, String author, String publisher) {
        List<Book> books = bookDao.lookupBooks(bookName, author, publisher);
        return books;
    }

    public Boolean borrowBook(String bookId, String userId) {
        boolean isBorrowing = bookDao.isBorrowing(bookId, userId);// 正在借着返回true，没接返回false
        Boolean haveBook = bookDao.haveBook(bookId);
        if (!isBorrowing && haveBook) {// 表示没借,并且有书可借
            // 添加借阅记录
            boolean flag1 = bookDao.inserBorrowing(bookId, userId);
            // 更改user的借阅信息
            boolean flag2 = userDao.addNum(userId);
            // 更改书库信息
            Boolean flag3 = bookDao.updateNum(bookId, 1);

            if (flag1 && flag2 && flag3)
                return true;
        } else {
            System.out.println("您之前已经借阅");
        }
        return false;
    }

    public boolean returnBook(String bookId, String userId) {
        boolean isBorrowing = bookDao.isBorrowing(bookId, userId);// 正在借着返回true，没接返回false
        if (isBorrowing) {
            // 删除借阅记录
            boolean flag1 = bookDao.delectBorrowing(bookId, userId);
            // 更改user的借阅信息
            boolean flag2 = userDao.deleteNum(userId);
            // 更改书库信息
            Boolean flag3 = bookDao.updateNum(bookId, -1);

            if (flag1 && flag2 && flag3)
                return true;
        } else {
            System.out.println("您当前并未借阅本书");
        }

        return false;
    }

}

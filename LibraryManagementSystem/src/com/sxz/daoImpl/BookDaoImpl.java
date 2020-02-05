/**
 * Project Name:LibraryManagementSystem
 * File Name:BookDaoImpl.java
 * Package Name:com.sxz.daoImpl
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.daoImpl;

import java.util.List;

import com.sxz.entity.Book;
import com.sxz.utils.JDBCUtil;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class BookDaoImpl {

    public List<Book> lookupBooks(String bookName, String author, String publisher) {
        String sql = "select * from book where 1=1 and bookName like '%" + bookName + "%'";
        if (author != null) {
            sql += " and author like '%" + author + "%' ";
        }
        if (publisher != null) {
            sql += " and publisher like '%" + publisher + "%'";
        }
        sql += ";";
        List<Book> books = JDBCUtil.getList(Book.class, sql);
        return books;
    }

    public boolean inserBorrowing(String bookId, String userId) {
        String sql = "insert into borrowing(bookId,userId) value (?,?)";
        boolean dml = JDBCUtil.getDML(sql, bookId, userId);
        return dml;
    }

    public boolean isBorrowing(String bookId, String userId) {
        String sql = "select count(*) from borrowing where bookId=? and userId=?;";
        int count = JDBCUtil.getCount(sql, bookId, userId);
        if (count > 0)
            return true;
        return false;
    }

    public Boolean haveBook(String bookId) {
        String sql = "SELECT (totalNumber-borrowedNum) AS num FROM book WHERE bookId=?;";
        int count = JDBCUtil.getCount(sql, bookId);
        if (count > 0)
            return true;
        return false;
    }

    public Boolean updateNum(String bookId, int i) {
        String sql = "select borrowedNum from book where bookId=?";
        int count = JDBCUtil.getCount(sql, bookId);

        sql = "update book set borrowedNum=? where bookId=?";
        boolean dml = JDBCUtil.getDML(sql, count + i, bookId);

        return dml;
    }

    public boolean delectBorrowing(String bookId, String userId) {
        String sql = "delete from borrowing where booKId=? and userId=?";
        boolean dml = JDBCUtil.getDML(sql, bookId, userId);

        return dml;
    }

}

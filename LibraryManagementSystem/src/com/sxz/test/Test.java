/**
 * Project Name:LibraryManagementSystem
 * File Name:Test.java
 * Package Name:com.sxz.test
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.test;

import java.util.List;

import com.sxz.daoImpl.BookDaoImpl;
import com.sxz.entity.Book;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> books = bookDao.lookupBooks("西游", "吴承", "人民出版社");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("完成");
    }
}

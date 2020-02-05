/**
 * Project Name:LibraryManagementSystem
 * File Name:borrowing.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Borrowing {
    private Integer bId;

    private Integer stuId;

    private Integer bookId;

    public Borrowing() {

    }

    public Borrowing(Integer stuId, Integer bookId) {
        this.stuId = stuId;
        this.bookId = bookId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Borrowing [bId=" + bId + ", stuId=" + stuId + ", bookId=" + bookId + "]";
    }

}

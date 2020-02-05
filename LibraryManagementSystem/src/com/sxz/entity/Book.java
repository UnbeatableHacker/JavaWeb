/**
 * Project Name:LibraryManagementSystem
 * File Name:Book.java
 * Package Name:com.sxz.entity
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.entity;

/**
 * Description: 图书类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class Book {
    private Integer bookId;

    private String bookName;

    private double price;

    private String author;

    private String publisher;

    private String publitionDate;

    private int totalNumber;

    private int borrowedNum;

    public Book() {

    }

    public Book(String bookName, double price, String author, String publisher, String publitionDate, int totalNumber,
            int borrowedNum) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.publitionDate = publitionDate;
        this.totalNumber = totalNumber;
        this.borrowedNum = borrowedNum;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublitionDate() {
        return publitionDate;
    }

    public void setPublitionDate(String publitionDate) {
        this.publitionDate = publitionDate;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getBorrowedNum() {
        return borrowedNum;
    }

    public void setBorrowedNum(int boorrowedNum) {
        this.borrowedNum = boorrowedNum;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", author=" + author
                + ", publisher=" + publisher + ", publitionDate=" + publitionDate + ", totalNumber=" + totalNumber
                + ", boorrowedNum=" + borrowedNum + "]";
    }

}

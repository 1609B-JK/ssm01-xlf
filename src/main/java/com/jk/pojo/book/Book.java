package com.jk.pojo.book;

import common.util.Page;

import java.io.Serializable;

/**
 * Created by Lynn-F_X on 2017/5/15.
 */
public class Book extends Page implements Serializable{

    private int bookID;

    private String bookName;

    private int bookPrice;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
}

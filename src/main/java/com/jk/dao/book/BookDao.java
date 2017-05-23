package com.jk.dao.book;

import com.jk.pojo.book.Book;

import java.util.List;

/**
 * Created by Lynn-F_X on 2017/5/15.
 */
public interface BookDao {

    void insertBook(Book book);

    int selectBookJsonCount();

    List<Book> selectBookJsonList(Book book);

    void deleteBook(Book book);

    Book selectbookByID(Book book);

    List<Book> selectBookList();

    void importBookExcel(List dataList);
}

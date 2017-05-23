package com.jk.service.book;

import com.jk.pojo.book.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Lynn-F_X on 2017/5/15.
 */
public interface BookService {

    void insertBook(Book book);

    int selectBookJsonCount(Book book);

    List<Book> selectBookJsonList(Book book);

    void deleteBook(Book book);


    Book selectbookByID(Book book);

    HSSFWorkbook exportBookExcel(Book book);

    void importBookExcel(MultipartFile excel);

}

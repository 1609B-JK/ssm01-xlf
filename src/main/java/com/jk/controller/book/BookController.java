package com.jk.controller.book;

import com.jk.pojo.book.Book;
import com.jk.service.book.BookService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lynn-F_X on 2017/5/15.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("insertBook")
    public String insertBook(Book book){
        bookService.insertBook(book);
        return "book/show-book";
    }

    @RequestMapping("selectBookList")
    @ResponseBody
    public Map<String, Object> selectBookList( Book book, int page, int rows) {
        //查询总条数
        int totalCount = bookService.selectBookJsonCount(book);
        if (0 == page) {
            page = 1;
        }
        if (0 == rows) {
            rows = 3;
        }
        book.setTotalCount(totalCount);
        book.setPageIndex(page);
        book.setPageSize(rows);
        book.countInfo();
        //查询列表
        List<Book> list = bookService.selectBookJsonList(book);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", totalCount);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deleteBook")
    @ResponseBody
    public String  deleteBook(Book book){
        bookService.deleteBook(book);
        return "";
    }

    @RequestMapping("toUpdatePage")
    public String toUpdatePage(Book book,Model model){
        Book b = bookService.selectbookByID(book);
        model.addAttribute("book",b);
        return "book/update_book";
    }

    @RequestMapping("exportBookExcel")
    public void exportBookExcel(Book book,HttpServletResponse response) throws IOException{
        //bookService.exportBookExcel(book);
       // 导出（web导出下载）
        HSSFWorkbook excel=bookService.exportBookExcel(book);;
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        //response.setContentType("application/vnd.ms-excel; charset=UTF-8");
        excel.write(output);
        output.close();
    }
    @RequestMapping("toImportBookExcel")
    public String toImportBookExcel(){
        return  "book/toImportBookExcel";
    }
    @ResponseBody
    @RequestMapping("importBookExcel")
    public void importBookExcel(@RequestParam(value="excel")MultipartFile excel){
            //解析excel文件
        bookService.importBookExcel(excel);
    }
}

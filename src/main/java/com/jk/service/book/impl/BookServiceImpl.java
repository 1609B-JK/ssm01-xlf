package com.jk.service.book.impl;

import com.jk.dao.book.BookDao;
import com.jk.pojo.book.Book;
import com.jk.service.book.BookService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Lynn-F_X on 2017/5/15.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    public int selectBookJsonCount(Book book) {
        return bookDao.selectBookJsonCount();
    }

    public List<Book> selectBookJsonList(Book book) {
        return bookDao.selectBookJsonList(book);
    }

    public void deleteBook(Book book) {
        bookDao.deleteBook(book);
    }

    public Book selectbookByID(Book book) {
        return bookDao.selectbookByID(book);
    }
//导出excel还要返回一个工作目录
    public HSSFWorkbook exportBookExcel(Book book) {
        //查询所有数据
        List<Book> bookList = bookDao.selectBookList();
        //1.创建excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建sheet
        HSSFSheet sheet = workbook.createSheet();
        //3.创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        HSSFCell cell = titleRow.createCell(0);
        cell.setCellValue("id");

        HSSFCell cell1 = titleRow.createCell(1);
        cell1.setCellValue("名字");

        HSSFCell cell2 = titleRow.createCell(2);
        cell2.setCellValue("price");

        int count = bookList.size();
        int rowIndex = 1;
        for (int i = 0; i < count ; i++) {
            HSSFRow dataRow = sheet.createRow(rowIndex++);
            HSSFCell rowCell = dataRow.createCell(0);
            rowCell.setCellValue(bookList.get(i).getBookID());
            HSSFCell rowCell1 = dataRow.createCell(1);
            rowCell1.setCellValue(bookList.get(i).getBookName());

            dataRow.createCell(2).setCellValue(bookList.get(i).getBookPrice());

        }
        //ioExpExcel(workbook,"e://bookExcel.xls");

        return workbook;
    }

    public void importBookExcel(MultipartFile excel ) {
        String fileName = excel.getOriginalFilename();
        String fileSufix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        //看获得过来的流是07还是03
        Workbook workbook = null;
        try {
            if(fileSufix.equals(".xls")){
                workbook = new HSSFWorkbook(excel.getInputStream());
            }else{
                workbook = new XSSFWorkbook(excel.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            //看最后一个条数是多少
        Sheet sheet = workbook.getSheetAt(0);
        int count = sheet.getLastRowNum();
        List list  =new ArrayList();
        for (int i = 0; i < count ; i++) {
            Row row = sheet.getRow(i+1);
            Book b = new Book();
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            b.setBookID(Integer.parseInt(row.getCell(0).getStringCellValue()));
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            b.setBookName(row.getCell(1).getStringCellValue());
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            b.setBookPrice(Integer.parseInt(row.getCell(2).getStringCellValue()));
            list.add(b);
        }
        List dataList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dataList.add(list.get(i));
            if(i%800==0 && i!=0){
                bookDao.importBookExcel(dataList);
                dataList.clear();
            }
        }

    }

    public static void ioExpExcel(HSSFWorkbook excel,String path){
        OutputStream out = null;
        try{
            out = new FileOutputStream(path);
            excel.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("数据已经写入excel");

    }

}
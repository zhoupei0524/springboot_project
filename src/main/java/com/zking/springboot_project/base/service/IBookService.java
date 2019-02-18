package com.zking.springboot_project.base.service;

import com.zking.springboot_project.base.model.Book;
import com.zking.springboot_project.base.util.PageBean;

import java.util.List;

public interface IBookService {

    List<Book> queryListBookPage(Book book, PageBean pageBean);

    Book selectByPrimaryKey(Integer id);


    void clrean();

}

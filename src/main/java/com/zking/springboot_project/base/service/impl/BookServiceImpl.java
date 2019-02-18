package com.zking.springboot_project.base.service.impl;

import com.zking.springboot_project.base.mapper.BookMapper;
import com.zking.springboot_project.base.model.Book;
import com.zking.springboot_project.base.service.IBookService;
import com.zking.springboot_project.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> queryListBookPage(Book book, PageBean pageBean) {
        return bookMapper.queryListBookPage(book);
    }

    //@Cacheable(value="my-redis-cache1",key = "'book'+#id",condition = "#id>2989")
    @CachePut(value = "my-redis-cache2")
    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = "my-redis-cache2")
    @Override
    public void clrean() {
        System.out.println("Redis Cache clrean.....");
    }
}

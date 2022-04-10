package com.book.service.impl;

import com.book.dao.BookDAO;
import com.book.pojo.Book;
import com.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }
}

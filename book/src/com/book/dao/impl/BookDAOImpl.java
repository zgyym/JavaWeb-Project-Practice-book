package com.book.dao.impl;

import com.book.dao.BookDAO;
import com.book.pojo.Book;
import com.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO{
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus = 0");
    }

    @Override
    public Book getBookById(Integer id) {
        return load("select * from t_book where id = ?",id);
    }
}

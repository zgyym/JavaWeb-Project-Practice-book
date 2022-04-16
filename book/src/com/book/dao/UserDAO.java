package com.book.dao;

import com.book.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);
    void addUser(User user);
}

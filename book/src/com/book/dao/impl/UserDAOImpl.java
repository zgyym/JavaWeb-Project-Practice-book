package com.book.dao.impl;

import com.book.dao.UserDAO;
import com.book.pojo.User;
import com.myssm.basedao.BaseDAO;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return super.load("select * from t_user where uname = ? and pwd = ?",uname,pwd);
    }
}

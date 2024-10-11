package com.ebi.springbootspringsecurity.dao;


import com.ebi.springbootspringsecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}

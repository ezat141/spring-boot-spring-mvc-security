package com.ebi.springbootspringsecurity.dao;

import com.ebi.springbootspringsecurity.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;
    public UserDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public User findByUserName(String theUserName) {
        // retrieve/read from database using username
        TypedQuery<User> query = entityManager.createQuery("from User where userName=:uName and enabled=true", User.class);
        query.setParameter("uName", theUserName);

        User theUser = null;
        try {
            theUser = query.getSingleResult();

        } catch (Exception e) {
            theUser = null;
        }




        return theUser;
    }
}

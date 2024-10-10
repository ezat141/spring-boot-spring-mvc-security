package com.ebi.springbootspringsecurity.dao;

import com.ebi.springbootspringsecurity.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository

public class RoleDaoImpl implements RoleDao {
    private EntityManager entityManager;
    public RoleDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public Role findRoleByName(String theRoleName) {
        // retrieve/read from database using name
        TypedQuery<Role> query = entityManager.createQuery("from Role where name=:roleName", Role.class);
        query.setParameter("roleName", theRoleName);
        Role theRole = null;

        try{
            theRole = query.getSingleResult();

        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }
}

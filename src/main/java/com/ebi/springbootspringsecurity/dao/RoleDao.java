package com.ebi.springbootspringsecurity.dao;


import com.ebi.springbootspringsecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}

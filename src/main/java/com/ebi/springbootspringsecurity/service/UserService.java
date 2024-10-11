package com.ebi.springbootspringsecurity.service;


import com.ebi.springbootspringsecurity.entity.User;
import com.ebi.springbootspringsecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}

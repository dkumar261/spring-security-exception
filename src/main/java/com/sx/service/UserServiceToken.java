package com.sx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sx.domain.User;
import com.sx.model.exception.CustomException;
import com.sx.repository.UserRepository;

@Service
public class UserServiceToken implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.getUserByName(userName)
				.orElseThrow(() -> new CustomException("Invalid User or This user is not found in system."));
		return user;
	}
}
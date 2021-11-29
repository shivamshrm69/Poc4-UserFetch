package com.poc4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc4.entity.User;
import com.poc4.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> allUser() {

		try {
			List<User> users = userRepository.findAll();
			return users;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public User userById(int user_id) {

		try {
			Optional<User> opt = userRepository.findById(user_id);
			User user = opt.get();
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean deleteById(int user_id) {

		try {
			userRepository.deleteById(user_id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

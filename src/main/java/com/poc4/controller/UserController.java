package com.poc4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc4.entity.User;
import com.poc4.feign.FeignClientRequest;
import com.poc4.response.ReturnResponse;
import com.poc4.service.UserService;

@RestController
@RequestMapping("/fetch")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	FeignClientRequest feignClientRequest;

	@GetMapping("/allUser")
	public ReturnResponse allUser() {
		ReturnResponse response = new ReturnResponse();

		List<User> users = userService.allUser();
		if (users == null) {
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		if (users.isEmpty()) {
			response.setSuccess(true);
			response.getResult().put("success", "no users found");
			return response;
		}

		response.setSuccess(true);
		response.getResult().put("success", users);
		return response;
	}

	@GetMapping("/userById/{user_id}")
	public ReturnResponse userById(@PathVariable int user_id) {
		ReturnResponse response = new ReturnResponse();
		User user = userService.userById(user_id);
		if (user == null) {
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", user);
		return response;
	}

	@DeleteMapping("/deleteById/{user_id}")
	public ReturnResponse deleteById(@PathVariable int user_id) {
		ReturnResponse response = new ReturnResponse();

		boolean result = userService.deleteById(user_id);
		feignClientRequest.deleteAddressByUserId(user_id);
		if (result == false) {
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", "user deleted");
		return response;
	}

}

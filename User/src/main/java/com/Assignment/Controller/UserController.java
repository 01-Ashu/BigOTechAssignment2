package com.Assignment.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.Dto.UserDto;
import com.Assignment.Services.UserServices;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserServices UserService;
	
	@PostMapping("/")
	public UserDto createProduct(@RequestBody UserDto usr) {
		return this.UserService.CreateUser(usr);	
	}
	@GetMapping("/")
	public List<UserDto> getAllUser(){
		return this.UserService.GetAllUser();
		
	}
	
	@GetMapping("/{Id}")
	public UserDto GetUserById(@PathVariable UUID Id) {
		return this.UserService.GetUserById(Id);
	}
	
	
	
}

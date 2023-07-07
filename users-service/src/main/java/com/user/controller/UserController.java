package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDTO;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping(value="/get-all-users", produces = "application/json")
	public ResponseEntity<List<UserDTO>> adminGetAllUsers() {
		List<UserDTO> products = userServiceImpl.getAllUsers();
		return new ResponseEntity<>(products,HttpStatus.OK); 
	}
	
	@GetMapping(value="/get-user", produces = "application/json")
	public ResponseEntity<UserDTO> adminGetUser(@RequestParam Long userId) {
		UserDTO product = userServiceImpl.getUser(userId);
		return new ResponseEntity<>(product,HttpStatus.OK); 
	}
	
	@PostMapping(value = "/add-user", produces = "application/json")
	public ResponseEntity<UserDTO> adminAddUser(@Valid @RequestBody UserDTO user){
		return new ResponseEntity<>(userServiceImpl.addUser(user),HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/update-user", produces = "application/json")
	public ResponseEntity<UserDTO> adminUpdateUser(@Valid @RequestBody UserDTO user){
		return new ResponseEntity<>(userServiceImpl.updateUser(user),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value = "/delete-user", produces = "application/json")
	public ResponseEntity<UserDTO> adminUpdateUser(@RequestParam Long userId){
		return new ResponseEntity<>(userServiceImpl.deleteUser(userId),HttpStatus.ACCEPTED);
		
	}

}

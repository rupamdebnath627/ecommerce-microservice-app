package com.user.service;

import java.util.List;

import com.user.dto.UserDTO;

public interface UserService {

	public List<UserDTO> getAllUsers();
	public UserDTO getUser(Long userId);
	public UserDTO addUser(UserDTO user);
	public UserDTO updateUser(UserDTO user);
	public UserDTO deleteUser(Long userId);
}

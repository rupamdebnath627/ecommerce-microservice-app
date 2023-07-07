package com.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDTO;
import com.user.entity.Users;
import com.user.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	@Override
	public List<UserDTO> getAllUsers() {
		return userRepo
				.findAll()
				.stream()
				.map(user -> mapper.map(user,UserDTO.class))
				.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public UserDTO getUser(Long userId) {
		if(userRepo.existsById(userId)) {
			return mapper.map(userRepo.findById(userId).orElse(null),UserDTO.class);
		}
		return null;
	}

	@Transactional
	@Override
	public UserDTO addUser(UserDTO user) {
		final Users currUser = mapper.map(user, Users.class);
		Long userId = userRepo.save(currUser).getUserId();
		return mapper.map(userRepo.findById(userId).orElse(null),UserDTO.class);
	}

	@Transactional
	@Override
	public UserDTO updateUser(UserDTO user) {
		if(userRepo.existsById(user.getUserId())) {
			final Users currUser = mapper.map(user, Users.class);
			return mapper.map(userRepo.save(currUser),UserDTO.class);
		}
		return null;
	}

	@Transactional
	@Override
	public UserDTO deleteUser(Long userId) {
		if(userRepo.existsById(userId)) {
			final Users currUser = userRepo.findById(userId).orElse(null);
			userRepo.deleteById(userId);
			return mapper.map(currUser,UserDTO.class);
		}
		return null;
	}

}

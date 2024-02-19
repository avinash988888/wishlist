package com.wishlist.service;

import java.util.List;

import com.wishlist.payloads.UserDto;

public interface UserService {
    // Create User
	UserDto createUser(UserDto userDto);
	// Update User
	UserDto updateUser(UserDto userDto, Integer userId);
	
	// Get User By Id
	UserDto getUserById(Integer userId);
	//Get allUser
	List<UserDto> getAllUser();
	// Delete User
	void deleteUser(Integer userId);
}

package com.wishlist.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wishlist.entity.User;
import com.wishlist.exception.ResourceNotFoundException;
import com.wishlist.mapper.DtoToEntityMapper;
import com.wishlist.mapper.EntityToDtoMapper;
import com.wishlist.payloads.UserDto;
import com.wishlist.repository.UserRepo;
import com.wishlist.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToEntityMapper.dtoToUser(userDto);
		User saveUser = this.userRepo.save(user);
		return this.entityToDtoMapper.userTodto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User saveuser = this.userRepo.save(user);
		UserDto userTodto = this.entityToDtoMapper.userTodto(saveuser);
		return userTodto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.entityToDtoMapper.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDto = users.stream().map(user -> this.entityToDtoMapper.userTodto(user))
				.collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		this.userRepo.delete(user);

	}

}

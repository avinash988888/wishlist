package com.wishlist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wishlist.payloads.ApiResponse;
import com.wishlist.payloads.UserDto;
import com.wishlist.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
	@Autowired
	private UserService userService;

	// Create the User
	//http://localhost:8081/api/users/saveUser
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// Update the User
	//http://localhost:8081/api/users/{userId}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uId) {
		UserDto updateUser = userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updateUser);
	}

	// Get User By Id
	//http://localhost:8081/api/users/{userId}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {

		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
    // Get all User
	//http://localhost:8081/api/users/
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {

		return ResponseEntity.ok(this.userService.getAllUser());
	}
	// Delete User
	//http://localhost:8081/api/users/{userId}
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId ){
    this.userService.deleteUser(userId);
    return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully ",true),HttpStatus.OK);	 
	}

}

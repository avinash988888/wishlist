package com.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.payloads.ApiResponse;
import com.wishlist.payloads.WishListDto;
import com.wishlist.service.WishListServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/wishlists")
public class WishListController {
    
	@Autowired
	private WishListServices wishListServices;
	
	//http://localhost:8081/api/wishlists/saveWishlist
	// Create WishList
	@PostMapping("/saveWishlist")
	public ResponseEntity<WishListDto> createWishList(@Valid @RequestBody WishListDto wishListDto){
		WishListDto createWishList = this.wishListServices.createWishList(wishListDto);
		return new ResponseEntity<>(createWishList,HttpStatus.CREATED);
	}
	
	//Get all WishList
	@GetMapping("/")
	public ResponseEntity<List<WishListDto>> getAllWishList(){
		List<WishListDto> wishList = this.wishListServices.getWishList();
		return new ResponseEntity<List<WishListDto>>(wishList,HttpStatus.OK);
	}
	// GetWishlist By Id
    
	@GetMapping("/{wishlistId}")
	public ResponseEntity<WishListDto> getWishListById(@PathVariable("wishlistId") Integer id){
		WishListDto wishList = this.wishListServices.getWishListById(id);
		return ResponseEntity.ok(wishList);
	}
	// Delete WishList
	@DeleteMapping("/{wishlistId}")
	public ResponseEntity<ApiResponse> deleteWishList(@PathVariable("wishlistId") Integer id){
		this.wishListServices.deleteWishList(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("WishList deleted successfully ",true),HttpStatus.OK);
	}
	
}

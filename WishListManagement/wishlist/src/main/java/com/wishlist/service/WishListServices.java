package com.wishlist.service;

import java.util.List;

import com.wishlist.payloads.WishListDto;

public interface WishListServices {
    
	// Create WishList
	WishListDto createWishList(WishListDto wishListDto);
	
	// get all WishList
    List<WishListDto> getWishList();
    
    // Get WishList By Id
    WishListDto getWishListById(Integer id);
    
    //Delete WishList
   
    void deleteWishList(Integer id);
    
}

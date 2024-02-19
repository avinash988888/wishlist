package com.wishlist.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wishlist.entity.User;
import com.wishlist.entity.Wishlist;
import com.wishlist.payloads.UserDto;
import com.wishlist.payloads.WishListDto;

@Component
public class DtoToEntityMapper {
	@Autowired
	private ModelMapper modelMapper;

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;

	}

	public Wishlist dtoToWishList(WishListDto wishListDto) {
		Wishlist wishlist = this.modelMapper.map(wishListDto, Wishlist.class);
		return wishlist;
	}

}

package com.wishlist.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wishlist.entity.User;
import com.wishlist.entity.Wishlist;
import com.wishlist.payloads.UserDto;
import com.wishlist.payloads.WishListDto;


@Component
public class EntityToDtoMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	
	public UserDto userTodto(User user) {
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
		return userDto;
	}

	public WishListDto wishListTodto(Wishlist wishlist) {
		WishListDto wishListDto = this.modelMapper.map(wishlist, WishListDto.class);
		return wishListDto;
	}

}

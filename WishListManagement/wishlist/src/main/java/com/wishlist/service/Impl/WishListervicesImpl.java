package com.wishlist.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.entity.User;
import com.wishlist.entity.Wishlist;
import com.wishlist.exception.ResourceNotFoundException;
import com.wishlist.mapper.DtoToEntityMapper;
import com.wishlist.mapper.EntityToDtoMapper;
import com.wishlist.payloads.WishListDto;
import com.wishlist.repository.UserRepo;
import com.wishlist.repository.WishListRepo;
import com.wishlist.service.WishListServices;

@Service
public class WishListervicesImpl implements WishListServices {
    
	@Autowired
	private WishListRepo wishListRepo;
	
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;

	@Override
	public WishListDto createWishList(WishListDto wishListDto) {
		Wishlist wishList = dtoToEntityMapper.dtoToWishList(wishListDto);
		Wishlist saveWishList = this.wishListRepo.save(wishList);
		return entityToDtoMapper.wishListTodto(saveWishList);
	}

	@Override
	public List<WishListDto> getWishList() {
		List<Wishlist> wishLists = this.wishListRepo.findAll();
		List<WishListDto> wishListDto = wishLists.stream().map(wishlist -> this.entityToDtoMapper.wishListTodto(wishlist)).collect(Collectors.toList());
		return wishListDto;
	}

	@Override
	public WishListDto getWishListById(Integer id) {
		Wishlist wishlist = this.wishListRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("WishList", "id", id));
		return entityToDtoMapper.wishListTodto(wishlist);
	}

	@Override
	public void deleteWishList(Integer id) {
		Wishlist wishlist = this.wishListRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("WishList", "id", id));
		this.wishListRepo.delete(wishlist);
	}

}

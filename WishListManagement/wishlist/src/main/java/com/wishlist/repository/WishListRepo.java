package com.wishlist.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wishlist.entity.User;
import com.wishlist.entity.Wishlist;


public interface WishListRepo extends JpaRepository<Wishlist, Integer>{

	List<Wishlist> findWishListByUser(User user);
	
}

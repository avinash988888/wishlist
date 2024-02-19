package com.wishlist.payloads;

import java.util.Date;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListDto {

	
	private Integer id;
	
	@NotEmpty
	@Size(min = 4,max = 10,message="WishList title must be minimum 4 to 10 character !!")
	private String wishTitle;
	@NotEmpty
	@Size(min = 4,max = 50,message="WishList Content must be minimum 4 to 50 character !!")
	private String wishlistContent;
	
	private Date wishlistDate;
}

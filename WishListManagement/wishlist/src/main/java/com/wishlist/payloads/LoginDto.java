package com.wishlist.payloads;

import lombok.Data;

@Data
public class LoginDto {
	
    private String usernameOrEmail;
    private String password;


}

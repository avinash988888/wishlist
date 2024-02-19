package com.wishlist.payloads;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int userId;
	
	@NotEmpty
	@Size(min = 4,max = 20,message="UserName must be minimum 4 to 20 charcter !!")
	private String name;
	@Email(message="Your EmailId is not valid !!")
	private String email;
	@NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" , message = "It contains at least 8 characters and at most 20 characters.\r\n"
    		+ "It contains at least one digit.\r\n"
    		+ "It contains at least one upper case alphabet.\r\n"
    		+ "It contains at least one lower case alphabet.\r\n"
    		+ "It contains at least one special character which includes !@#$%&*()-+=^.\r\n"
    		+ "It doesn’t contain any white space.")
	private String password;
}

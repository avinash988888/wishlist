package com.wishlist.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    @Column(name = "title")
	private String wishTitle;
	@Column(name ="content")
	private String wishlistContent;
	
	private Date wishlistDate;
	
	@ManyToOne
    @JoinColumn(name ="user_id" , nullable = false)
	private User user;
	
	
}

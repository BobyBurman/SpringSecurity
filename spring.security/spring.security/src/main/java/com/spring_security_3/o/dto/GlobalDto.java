package com.spring_security_3.o.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GlobalDto {
	
	private Long productId;
	
	private String productName;
	
	private String productPrice;
	
	private String productQty;

}

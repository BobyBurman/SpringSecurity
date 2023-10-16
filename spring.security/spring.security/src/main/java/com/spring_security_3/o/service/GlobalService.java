package com.spring_security_3.o.service;

import java.util.List;

import com.spring_security_3.o.dto.GlobalDto;
import com.spring_security_3.o.entity.UserInfo;

public interface GlobalService{
	
	public GlobalDto saveGlobalDto(GlobalDto globalDto);

	public List<GlobalDto> getAllProduct();

	public GlobalDto getProductById(Long productId);

}

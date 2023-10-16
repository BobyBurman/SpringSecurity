package com.spring_security_3.o.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_3.o.dto.GlobalDto;

import com.spring_security_3.o.service.GlobalService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RequestMapping("/product")
@RestController()
public class GlobalController {
	
	public GlobalService globalService;
	
	//Create products
	@PostMapping("/create")
	public ResponseEntity<GlobalDto> saveGlobalDto(@RequestBody GlobalDto globalDto) {
		GlobalDto savedGlobalDto=globalService.saveGlobalDto(globalDto);
		return new ResponseEntity<GlobalDto>(savedGlobalDto, HttpStatus.CREATED);
	}
	
	//Get All products
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/getAll")
	public ResponseEntity<List<GlobalDto>> getAllProduct(){
		List<GlobalDto> globalDtoList=globalService.getAllProduct();
		return new ResponseEntity<List<GlobalDto>>(globalDtoList,HttpStatus.OK);
	}
	
	//Get Product by Id
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("{productId}")
	public ResponseEntity<GlobalDto> getByProductId(@PathVariable("productId") Long productId){
		GlobalDto globalLDto=globalService.getProductById(productId);
		return new ResponseEntity<GlobalDto>(globalLDto,HttpStatus.OK);
	}
	

}

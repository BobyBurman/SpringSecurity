package com.spring_security_3.o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_3.o.entity.UserInfo;
import com.spring_security_3.o.service.DummyService;

@RestController
@RequestMapping("/dummy")
public class DummySecurityController {
	
	@Autowired
	private DummyService dummyService;
	
	@PostMapping("/new")
	public String AddUser(@RequestBody UserInfo userInfo) {
		return dummyService.addUser(userInfo);
	}

}

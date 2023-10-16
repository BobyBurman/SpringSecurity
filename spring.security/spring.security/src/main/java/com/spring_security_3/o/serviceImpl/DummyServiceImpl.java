package com.spring_security_3.o.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring_security_3.o.entity.UserInfo;
import com.spring_security_3.o.repository.UserInfoRepository;
import com.spring_security_3.o.service.DummyService;



@Service
public class DummyServiceImpl implements DummyService {
    
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "user added to system";
	}

}

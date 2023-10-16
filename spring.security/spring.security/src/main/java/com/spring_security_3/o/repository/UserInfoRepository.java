package com.spring_security_3.o.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_3.o.entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{

	Optional<UserInfo> findByName(String username);


}

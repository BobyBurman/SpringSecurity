package com.spring_security_3.o.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_security_3.o.entity.GlobalEntity;



public interface GlobalRepository extends JpaRepository<GlobalEntity,Long>{
	
}
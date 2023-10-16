package com.spring_security_3.o.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring_security_3.o.dto.GlobalDto;
import com.spring_security_3.o.entity.GlobalEntity;
import com.spring_security_3.o.repository.GlobalRepository;
import com.spring_security_3.o.service.GlobalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GlobalServiceImpl implements GlobalService{
	
	private ModelMapper MAPPER;
	
	private GlobalRepository globalRepository;
	
	@Override
	public GlobalDto saveGlobalDto(GlobalDto globalDto) {
		// map dto to jpa
		GlobalEntity globalEntity=MAPPER.map(globalDto,GlobalEntity.class);
		
		GlobalEntity savedGlobalEntity=globalRepository.save(globalEntity);
		
		//jpa to dto
		GlobalDto savedGlobalDto=MAPPER.map(globalEntity,GlobalDto.class);
		
		return savedGlobalDto;
	}

	@Override
	public List<GlobalDto> getAllProduct() {
		// Get All products
		List<GlobalEntity> globalEntities=globalRepository.findAll();
		
		List<GlobalDto> globalDto=new ArrayList<GlobalDto>();
		for(GlobalEntity globalEntity:globalEntities) {
			//jpa to dto
			GlobalDto getGlobalDto=MAPPER.map(globalEntity,GlobalDto.class);
			
			globalDto.add(getGlobalDto);
		}
		
		return globalDto;
	}

	@Override
	public GlobalDto getProductById(Long productId) {
		// get product from product id
		Optional<GlobalEntity> globalEntity=globalRepository.findById(productId);
		GlobalDto globalDto=MAPPER.map(globalEntity.get(),GlobalDto.class);
		return globalDto;
	}

}

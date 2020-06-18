package com.inspot.workshadow.test.service;

import org.springframework.stereotype.Service;

import com.inspot.workshadow.test.model.TestEntity;

@Service
public class TestService {
	private static TestEntity uservo;
	
	public void add(String newusername) {
		uservo = TestEntity.builder().name(newusername).build();
	}
	
	public void add(TestEntity test) {
		uservo = test;
	}

	public TestEntity getOneUser() {
		return uservo;
	}
	
//	private <R, T> T sourceToDestinationTypeCasting(R source, T destination) {
//		modelMapper.map(source, destination);
//		return destination;
//	}
}

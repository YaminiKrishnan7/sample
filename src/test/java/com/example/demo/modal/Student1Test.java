package com.example.demo.modal;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Student1Test {
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@InjectMocks
	Student1 student;
	
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void setId_Test() throws NoSuchFieldException, SecurityException {
		
		Field field =Student1.class.getDeclaredField("id");
		field.setAccessible(true);

	}
	
	@Test
	public void setName_Test() throws NoSuchFieldException, SecurityException {
		Field field =Student1.class.getDeclaredField("name");
		field.setAccessible(true);
	}
	
	@Test
	public void setAddress_Test() throws NoSuchFieldException, SecurityException {
		Field field =Student1.class.getDeclaredField("address");
		field.setAccessible(true);
	}
	
	@Test
	public void setPhn_num_Test() throws NoSuchFieldException, SecurityException {
		Field field =Student1.class.getDeclaredField("phn_num");
		field.setAccessible(true);
	}

	@Test
	public void getIdTest() {
		
		student.setId(2L);
		assertTrue(student.getId()==2L);

	}
	
	@Test
	public void getName_Test(){
		student.setName("yamini");
		assertTrue(student.getName()=="yamini");
	
	}
	
	@Test
	public void getAddress_Test() {
		student.setAddress("bangalore");
		assertTrue(student.getAddress()=="bangalore");
	}
	
	@Test
	public void getPhn_num() {
		student.setPhn_num(990077);
		assertTrue(student.getPhn_num()==990077);    
	}
	
}

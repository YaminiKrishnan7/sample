package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.modal.Student1;
import com.example.demo.service.Student1ServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Student1ControllerTest {

	@InjectMocks
 Student1Controller controller;

	
	@Mock
	Student1ServiceImpl studentServiceImpl;

	@Test
	public void getAllStudent_Test() {
		controller.getAllStudent();
	}
	@Test
	public void getStudentById_Test() {
		long id=1;
		controller.getStudentById(id);
	}
	@Test
	public void createStudent_Test() {
		Student1 s =new Student1();
		controller.createStudent(s);
	}
	@Test
	public void updateStudent_Test() {
		long id=1;
		Student1 s =new Student1();
		controller.updateStudent(id, s);
	}
	@Test
	public void deleteStudent_Test() {
		long id=1;
		controller.deleteStudent(id);
	}

}

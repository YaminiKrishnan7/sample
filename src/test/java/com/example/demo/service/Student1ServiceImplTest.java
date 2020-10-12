package com.example.demo.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

//import org.junit.Test;// imports for junit 4 Test
import org.junit.jupiter.api.Test;//imports for JUnit 5 test 
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.modal.Student1;
import com.example.demo.repository.Student1Repository;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Student1ServiceImplTest {
	@Mock
	Student1ServiceImplTest studentTest;
	@InjectMocks
	Student1ServiceImpl impl;

	//	 @Rule
	//	  public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	Student1Repository student1Repo;

	@Mock
	Student1Service studentService;

	@Mock
	Student1 student;

	@Mock
	ResourceNotFound rs;

	//    @Before
	//	public void setUp() throws Exception {
	//		MockitoAnnotations.initMocks(this);
	//		impl = new Student1ServiceImpl();
	//	}

	@Test
	public void createStudent_Test() {
		Student1 s=new Student1();
		impl.createStudent(s);
	}

	@Test
	public void getAllStudent_Test() {
		impl.getAllStudent();
	}


	@Test
	public void getStudentById_Test() {
		Long StudentId=3L;
		when(student1Repo.findById(StudentId)).thenReturn(Optional.of(student));
		Student1 getClient = impl.getStudentById(StudentId);
		assertEquals(getClient, student); 
	}

	@Test
	public void getStudentById_else_Test() {  
		Long StudentId=3L;

		when(rs.getCause()).thenReturn(rs);
		assertThrows(ResourceNotFound.class,() -> impl.getStudentById(StudentId));

	}

	@Test
	public void updateStudent_Test() {
		Student1 s=new Student1();
		s.setId(1L);
		s.setName("janani");
		s.setAddress("bombay");
		s.setPhn_num(963587423);
		student1Repo.save(s);
		Long StudentId = 1L;
		when(student1Repo.findById(StudentId)).thenReturn(Optional.of(student));
		Student1 getClient = impl.updateStudent(s);
		assertEquals(getClient, student); 
	}

	@Test
	public void updateStudent_else_Test() {
		Student1 s=new Student1();
		s.setId(0);
		s.setName("janani");
		s.setAddress("bombay");
		s.setPhn_num(963587423);
		student1Repo.save(s);
		Long StudentId = 0l;

		assertThrows(ResourceNotFound.class,() -> impl.updateStudent(s));

	}


	@Test
	public void deleteStudent_Test() {

		long StudentId = 1L;
		Student1 s=new Student1();
		s.setId(1L);
		s.setName("janani");
		s.setAddress("bombay");
		s.setPhn_num(963587423);
		student1Repo.delete(s);
		Optional<Student1> productDb =student1Repo.findById(StudentId);

		//	 student1Repo.delete(productDb.get());
		impl.deleteStudent(StudentId);

	}

	@Test
	public void deleteStudent_else_Test() {

		long StudentId = 1L;
		Student1 s=new Student1();
		s.setId(1L);
		s.setName("janani");
		s.setAddress("bombay");
		s.setPhn_num(963587423);
		student1Repo.delete(s);
		Optional<Student1> productDb =student1Repo.findById(StudentId);

		assertThrows(ResourceNotFound.class,() -> impl.updateStudent(s)); 
	}

}


package com.example.demo.service;
import java.util.List;

import com.example.demo.modal.Student1;

public interface Student1Service {
	Student1 createStudent(Student1 s );

	Student1 updateStudent(Student1 s);

    List < Student1 > getAllStudent();

    Student1 getStudentById(long StudentId);

     void deleteStudent(long id);

}

package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.modal.Student1;
import com.example.demo.repository.Student1Repository;

@Service
@Transactional
public  class Student1ServiceImpl implements Student1Service {


	@Autowired
	private Student1Repository studentRepository;
	
	public void setStudentRepository(Student1Repository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student1 createStudent(Student1 s) {
		return studentRepository.save(s);
		
		
	}

	@Override
	public Student1 updateStudent(Student1 s) {
		Optional < Student1 > productDb = studentRepository.findById(s.getId());

		if (productDb.isPresent()) {
			Student1 studentUpdate = productDb.get();
			studentUpdate.setId(s.getId());
			studentUpdate.setName(s.getName());
			studentUpdate.setAddress(s.getAddress());
			studentUpdate.setPhn_num(s.getPhn_num());
			studentRepository.save(studentUpdate);
			return studentUpdate;
		} else {
			throw new ResourceNotFound("Record not found with id : " + s.getId());
		}
	}

	@Override
	public List < Student1 > getAllStudent() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student1 getStudentById(long StudentId) {

		Optional < Student1 > productDb = this.studentRepository.findById(StudentId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFound("Record not found with id : " + StudentId);
		}
	}

	@Override
	public void deleteStudent(long StudentId) {
		Optional < Student1 > productDb = this.studentRepository.findById(StudentId);

		if (productDb.isPresent()) {
			this.studentRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFound("Record not found with id : " + StudentId);
		}

	}
}
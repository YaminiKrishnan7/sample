package com.example.demo.controller;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Student1;
import com.example.demo.service.Student1Service;

@RestController
public class Student1Controller{

    @Autowired
    private Student1Service student1Service;

    @GetMapping("/student1")
    public ResponseEntity < List < Student1 >> getAllStudent() {
        return ResponseEntity.ok().body(student1Service.getAllStudent());
    }

    @GetMapping("/student1/{id}")
    public ResponseEntity < Student1 > getStudentById(@PathVariable long id) {
        return ResponseEntity.ok().body(student1Service.getStudentById(id));
    }

    @PostMapping("/student1")
    public ResponseEntity < Student1 > createStudent(@RequestBody Student1 s) {
        return ResponseEntity.ok().body(this.student1Service.createStudent(s));
    }

    @PutMapping("/student1/{id}")
    public ResponseEntity < Student1 > updateStudent(@PathVariable long id, @RequestBody Student1 s) {
        s.setId(id);
        return ResponseEntity.ok().body(this.student1Service.updateStudent(s));
    }

    @DeleteMapping("/student1/{id}")
    public HttpStatus deleteStudent(@PathVariable long id) {
        this.student1Service.deleteStudent(id);
        return HttpStatus.OK;
    }
}
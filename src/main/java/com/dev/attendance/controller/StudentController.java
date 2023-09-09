package com.dev.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.attendance.models.Student;
import com.dev.attendance.service.StudentService;

@CrossOrigin("http://localhost:4200")
@RestController()
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@GetMapping("/students")
	public @ResponseBody List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/batches/{batchId}/students")
	public @ResponseBody List<Student> getBatchStudents(@PathVariable Integer batchId) {
		return studentService.getBatchStudents(batchId);
	}
	
	@GetMapping("/students/{id}")
	public @ResponseBody Student getStudents(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/students")
	public @ResponseBody Student createStudent(@RequestBody Student student) {
		System.out.println("In student creation");
		System.out.println(student);
		return studentService.createStudent(student);
	}
	
	@PutMapping("/students")
	public @ResponseBody Student updateStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public @ResponseBody String deleteStudent(@PathVariable String id) {
		boolean status = studentService.deleteStudent(id);
		if(status) {
			return "Student has been deleted";
		} else {
			return "Failed to delete the student";
		}		
	}
	
}

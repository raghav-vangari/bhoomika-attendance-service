package com.dev.attendance.service;

import java.util.List;

import com.dev.attendance.models.Student;

public interface StudentService {

	public List<Student> getStudents();
	public List<Student> getBatchStudents(Integer batchId);
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public Student getStudentById(String id);
	public Boolean deleteStudent(String id);
}

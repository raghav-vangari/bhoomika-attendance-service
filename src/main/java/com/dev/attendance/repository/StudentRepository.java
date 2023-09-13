package com.dev.attendance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.attendance.models.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
	public List<Student> findById(Integer studentId);
	public List<Student> findByBatchNumber(Integer batchNumber);
}

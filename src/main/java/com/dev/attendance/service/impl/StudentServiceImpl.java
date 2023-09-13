package com.dev.attendance.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.attendance.models.Batch;
import com.dev.attendance.models.Student;
import com.dev.attendance.repository.BatchRepository;
import com.dev.attendance.repository.StudentRepository;
import com.dev.attendance.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		for(Student student: studentRepository.findAll()) {
			students.add(student);
		}
		return students;
	}

	@Override
	public Student createStudent(Student student) {
		Batch batch = batchRepository.findByBatchNumber(student.getBatchNumber());
		if(batch != null) {
			Integer count = batch.getCount();
			batch.setCount(count + 1);
			batchRepository.save(batch);
			System.out.println("batch updated successfully");
		} else {
			Batch newBatch = new Batch(student.getBatchNumber(), 1, "6:00 PM");
			batchRepository.save(newBatch);
			System.out.println("Batch saved successfully");
		}
//		String uniqueID = UUID.randomUUID().toString();
//		student.setId(uniqueID);
		Student response = studentRepository.save(student);
		return response;
	}

	@Override
	public Student updateStudent(Student student) {
		Student response = studentRepository.save(student);
		return response;
	}

	@Override
	public Student getStudentById(String id) {
		Optional<Student> studentOp = studentRepository.findById(id);
		return studentOp.get();
	}

	@Override
	public Boolean deleteStudent(String id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Student> getBatchStudents(Integer batchNumber) {
		// TODO Auto-generated method stub
		return studentRepository.findByBatchNumber(batchNumber);
	}

}

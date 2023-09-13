package com.dev.attendance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.attendance.models.Attendance;
import com.dev.attendance.models.Batch;
import com.dev.attendance.models.Student;
import com.dev.attendance.repository.AttendanceRepository;
import com.dev.attendance.repository.BatchRepository;
import com.dev.attendance.repository.StudentRepository;
import com.dev.attendance.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public List<Attendance> addAttendance(List<Attendance> attendanceList, Integer batchNumber) {
		Batch batch = batchRepository.findByBatchNumber(batchNumber);
		System.out.println(batch);
		String batchTime = batch.getBatchTime();
		Integer batchStartTimeInMinutes = convertBatchTimeToMin(batchTime);
		
		for(Attendance attendance: attendanceList) {
			attendance.setSubmitted(true);
			Integer studentAttendingTimeInMinutes = convertBatchTimeToMin(attendance.getAttendingTime());
			Integer attendDelay = studentAttendingTimeInMinutes - batchStartTimeInMinutes;
			if(attendance.getStatus().equals("Absent") || attendDelay >= 40) {
				List<Student> students = studentRepository.findById(attendance.getStudentId());
				Student student = students.get(0);
				Integer deductFromBalance = student.getBalance() - 200;
				System.out.println("Student is delayed*******");
				System.out.println("Balance before deducting: " + student.getBalance());
				System.out.println("Balance to be deducted: " + deductFromBalance);
				student.setBalance(deductFromBalance);
				Student updatedStudentBal = studentRepository.save(student);
				System.out.println("Balance after updating: " + updatedStudentBal.getBalance());
			} else if(attendDelay > 0) { 
				List<Student> students = studentRepository.findById(attendance.getStudentId());
				Student student = students.get(0);
				Integer deductFromBalance = student.getBalance() - (attendDelay * 5);
				System.out.println("Student is delayed*******");
				System.out.println("Balance before deducting: " + student.getBalance());
				System.out.println("Balance to be deducted: " + deductFromBalance);
				student.setBalance(deductFromBalance);
				Student updatedStudentBal = studentRepository.save(student);
				System.out.println("Balance after updating: " + updatedStudentBal.getBalance());
			} else {
				System.out.println("Student is on time!");
			}
		}
		return attendanceRepository.saveAll(attendanceList);
	}
	
	private Integer convertBatchTimeToMin(String time) {
		String[] batchTimeSplit = time.split(":");
		Integer batchMin = 0;
		if(batchTimeSplit[1] != null) {
			String[] batchTimeSplitMin = batchTimeSplit[1].split(" ");
			batchMin = Integer.parseInt(batchTimeSplitMin[0]);
		}
		return batchMin;
	}

	@Override
	public List<Attendance> getAttendanceByDateandBatch(String attendanceDate, Integer batchNumber) {
		System.out.println("In getAttendanceByDate");
		System.out.println("received date: " + attendanceDate);
		List<Attendance> attendanceList = attendanceRepository.findByAttendanceDateAndBatch(attendanceDate, batchNumber);
		System.out.println(attendanceList);
		return attendanceList;
	}

}

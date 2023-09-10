package com.dev.attendance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.attendance.models.Attendance;

public interface AttendanceRepository extends MongoRepository<Attendance, Integer>{

	public List<Attendance> findByAttendanceDate(String attendanceDate);
	public List<Attendance> findByAttendanceDateAndBatch(String attendanceDate, Integer batch);
}

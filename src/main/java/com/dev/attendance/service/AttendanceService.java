package com.dev.attendance.service;

import java.util.List;

import com.dev.attendance.models.Attendance;

public interface AttendanceService {

	public List<Attendance> addAttendance(List<Attendance> attendanceList, Integer batchNumber);
	public List<Attendance> getAttendanceByDate(String attendanceDate);
}

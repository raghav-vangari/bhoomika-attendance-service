package com.dev.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.attendance.models.Attendance;
import com.dev.attendance.service.AttendanceService;

@CrossOrigin("http://localhost:4200")
@RestController
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;

	@PostMapping("/attendance/batch/{batchNumber}")
	public List<Attendance> addAttendance(@RequestBody List<Attendance> attendanceList,
			@PathVariable Integer batchNumber) {
		return attendanceService.addAttendance(attendanceList, batchNumber);
		
	}
	
	@GetMapping("/attendance/{attendanceDate}/batch/{batchNumber}")
	public List<Attendance> getAttendanceByDateandBatch(@PathVariable String attendanceDate, @PathVariable Integer batchNumber) {
		return attendanceService.getAttendanceByDateandBatch(attendanceDate, batchNumber);
	} 
}

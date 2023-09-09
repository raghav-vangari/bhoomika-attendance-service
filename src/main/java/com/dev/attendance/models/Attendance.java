package com.dev.attendance.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Attendance {

	@Id
	private String id;
	
	@Field
	private String attendanceDate;
	@Field
	private String attendingTime;
	@Field
	private String studentId;
	@Field
	private String status;
	@Field
	private Boolean submitted;
	@Field
	private String studentName;
	@Field
	private Boolean toggle;
	@Field
	private Boolean toSubmit;
	
	
	public Attendance() {}

	public Attendance(String id, String attendanceDate, String attendingTime, String studentId, String status,
			Boolean submitted, String studentName, Boolean toggle, Boolean toSubmit) {
		super();
		this.id = id;
		this.attendanceDate = attendanceDate;
		this.attendingTime = attendingTime;
		this.studentId = studentId;
		this.status = status;
		this.submitted = submitted;
		this.studentName = studentName;
		this.toggle = toggle;
		this.toSubmit = toSubmit;
	}

	public Boolean getToSubmit() {
		return toSubmit;
	}

	public void setToSubmit(Boolean toSubmit) {
		this.toSubmit = toSubmit;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Boolean getToggle() {
		return toggle;
	}

	public void setToggle(Boolean toggle) {
		this.toggle = toggle;
	}

	public Boolean getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Boolean submitted) {
		this.submitted = submitted;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendingTime() {
		return attendingTime;
	}
	public void setAttendingTime(String attendingTime) {
		this.attendingTime = attendingTime;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", attendanceDate=" + attendanceDate + ", attendingTime=" + attendingTime
				+ ", studentId=" + studentId + ", status=" + status + ", submitted=" + submitted + ", studentName="
				+ studentName + ", toggle=" + toggle + ", toSubmit=" + toSubmit + "]";
	}
	
}

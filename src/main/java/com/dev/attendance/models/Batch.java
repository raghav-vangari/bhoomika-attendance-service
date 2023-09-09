package com.dev.attendance.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Batch {

	@Id
	private Integer batchNumber;
	@Field
	private Integer count;
	@Field
	private String batchTime;
	
	public Batch() {}

	public Integer getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	@Override
	public String toString() {
		return "Batch [batchNumber=" + batchNumber + ", count=" + count + ", batchTime=" + batchTime + "]";
	}

	public Batch(Integer batchNumber, Integer count, String batchTime) {
		super();
		this.batchNumber = batchNumber;
		this.count = count;
		this.batchTime = batchTime;
	}	
}

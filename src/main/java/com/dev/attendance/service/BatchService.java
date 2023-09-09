package com.dev.attendance.service;

import java.util.List;

import com.dev.attendance.models.Batch;

public interface BatchService {

	public Batch addBatch(Batch batch);
	public List<Batch> getBatches();
}

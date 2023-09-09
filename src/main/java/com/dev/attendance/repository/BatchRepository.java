package com.dev.attendance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.attendance.models.Batch;

public interface BatchRepository extends MongoRepository<Batch, Integer>{

	public Batch findByBatchNumber(Integer batchNumber);
}

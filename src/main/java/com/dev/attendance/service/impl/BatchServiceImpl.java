package com.dev.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.attendance.models.Batch;
import com.dev.attendance.repository.BatchRepository;
import com.dev.attendance.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	BatchRepository batchRepository;
	
	@Override
	public Batch addBatch(Batch batch) {
		// TODO Auto-generated method stub
		Batch resBatch = batchRepository.findByBatchNumber(batch.getBatchNumber());
		System.out.println("res batch--->");
		System.out.println(resBatch);
		if(resBatch == null) {
			batch.setBatchTime("6:00 PM");
			return batchRepository.save(batch);
		} else {			
			return resBatch;
		}
	}

	@Override
	public List<Batch> getBatches() {
		// TODO Auto-generated method stub
		return batchRepository.findAll();
	}

	
}

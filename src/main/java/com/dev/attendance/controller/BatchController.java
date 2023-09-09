package com.dev.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.attendance.models.Batch;
import com.dev.attendance.service.BatchService;

@CrossOrigin("http://localhost:4200")
@Controller
public class BatchController {
	
	@Autowired
	BatchService batchService;

	@PostMapping("/batches")
	public @ResponseBody Batch addBatch(@RequestBody Batch batch) {
		return batchService.addBatch(batch);
	}
	
	@GetMapping("/batches")
	public @ResponseBody List<Batch> getBatches() {
		return batchService.getBatches();
	}
}

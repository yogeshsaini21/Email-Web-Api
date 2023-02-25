package com.masai.team6.Services;

import java.util.List;

import com.masai.team6.Payloads.BatchDto;

public interface BatchService {

	BatchDto saveBatches(BatchDto batchdto);
	
	List<BatchDto> MyBatches();
	
	BatchDto deleteBatch(Integer id);
}

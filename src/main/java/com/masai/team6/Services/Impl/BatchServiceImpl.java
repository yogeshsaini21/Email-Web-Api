package com.masai.team6.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.team6.Entities.Batch;
import com.masai.team6.Exception.ResourceNotFoundException;
import com.masai.team6.Payloads.BatchDto;
import com.masai.team6.Repository.BatchRepo;
import com.masai.team6.Services.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepo batchRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BatchDto saveBatches(BatchDto batchDto) {
		Batch batch = this.modelMapper.map(batchDto, Batch.class);
		batchRepo.save(batch);
		
		return this.modelMapper.map(batch, BatchDto.class);
	}

	@Override
	public List<BatchDto> MyBatches() {
		
		List<Batch> BatchListing= batchRepo.findAll();
		
		List<BatchDto> BatchDtos = BatchListing.stream().map(batch -> this.modelMapper.map(batch, BatchDto.class))
				.collect(Collectors.toList());
		return BatchDtos;
	}

	@Override
	public  BatchDto deleteBatch(Integer id) {
		Batch batch= batchRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Batch", "batch id", id));
		batchRepo.delete(batch);
		
		return this.modelMapper.map(batch, BatchDto.class);
	}

}


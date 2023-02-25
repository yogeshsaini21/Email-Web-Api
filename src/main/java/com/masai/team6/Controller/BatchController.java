package com.masai.team6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.team6.Entities.Batch;
import com.masai.team6.Payloads.ApiResponse;
import com.masai.team6.Payloads.BatchDto;
import com.masai.team6.Services.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
    private BatchService batchService;
	

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<BatchDto> saveBatches(@RequestBody BatchDto batchDto){
		
		BatchDto batchNew = this.batchService.saveBatches(batchDto);
		
		return new ResponseEntity<BatchDto>(batchNew, HttpStatus.CREATED);
	}
	
	@GetMapping("/mybatches")
	public ResponseEntity<List<BatchDto>> MyBatches(){

		List<BatchDto> batch= this.batchService.MyBatches();
		return new ResponseEntity<List<BatchDto>>(batch,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBatch(@PathVariable Integer id){

		this.batchService.deleteBatch(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Batch deleted successfully", true), HttpStatus.OK);
	}
}
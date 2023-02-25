package com.masai.team6.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Table(name="Batch")
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer batchId;
	
	@Column(name="batch_name")
	private String  batchName;
	


}


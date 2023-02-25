package com.masai.team6.Payloads;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.masai.team6.Entities.Lecture;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min = 4, message = "Min size of category title is 4")
	private String categoryTitle;
	
	
}

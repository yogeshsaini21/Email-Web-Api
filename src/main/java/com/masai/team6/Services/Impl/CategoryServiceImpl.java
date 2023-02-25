package com.masai.team6.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.team6.Entities.Category;
import com.masai.team6.Exception.ResourceNotFoundException;
import com.masai.team6.Payloads.CategoryDto;
import com.masai.team6.Repository.CategoryRepo;
import com.masai.team6.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelmapper.map(categoryDto, Category.class);
		Category addedCat  = this.categoryRepo.save(cat);
		
		return this.modelmapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id" , categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		
		Category updatedcat = this.categoryRepo.save(cat);
		
		
		return this.modelmapper.map(updatedcat, CategoryDto.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "category id", categoryId));
		this.categoryRepo.delete(cat);
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "category id", categoryId));
		
		
		return this.modelmapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories =  this.categoryRepo.findAll() ;
		
		List<CategoryDto> categoryDtos = categories.stream().map((cat)->this.modelmapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		
		return categoryDtos;
	}


}

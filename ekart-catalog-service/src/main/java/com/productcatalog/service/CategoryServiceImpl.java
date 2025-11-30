package com.productcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.model.dtos.CategoryRequest;
import com.productcatalog.model.dtos.CategoryResponse;
import com.productcatalog.model.entities.Category;
import com.productcatalog.repository.ICategoryRepository;
import com.productcatalog.util.ProductMapper;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private ProductMapper mapper;
	@Override
	public void addCategory(CategoryRequest categoryRequest) {
		categoryRepository.save(mapper.toCategoryEntity(categoryRequest));
	}

	@Override
	public void updateCategory(CategoryRequest categoryRequest) {
		categoryRepository.save(mapper.toCategoryEntity(categoryRequest));
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	@Override
	public CategoryResponse getById(int categoryId) {
		Category category = categoryRepository.findById(categoryId)
				  .orElseThrow(()-> new RuntimeException("invalid category"));
				return mapper.toCategoryResponse(category);
	}

}

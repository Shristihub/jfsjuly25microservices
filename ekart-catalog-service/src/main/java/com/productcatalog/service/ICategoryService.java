package com.productcatalog.service;

import com.productcatalog.model.dtos.CategoryRequest;
import com.productcatalog.model.dtos.CategoryResponse;

public interface ICategoryService {
	
	//CRUD operation
	void addCategory(CategoryRequest categoryRequest);
	void updateCategory(CategoryRequest categoryRequest);
	void deleteCategory(int categoryId);
	CategoryResponse getById(int categoryId) ;
	
}










package com.productcatalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.dtos.CategoryRequest;
import com.productcatalog.model.dtos.CategoryResponse;
import com.productcatalog.service.ICategoryService;

@RestController
@RequestMapping("/catalog-service/v1")
@RefreshScope
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

//		http://localhost:8084/catalog-service/v1/category
	@PostMapping("/category")
	ResponseEntity<Void> addCategory(@RequestBody CategoryRequest categoryRequest) {
		categoryService.addCategory(categoryRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//		http://localhost:8084/catalog-service/v1/category
	@PutMapping("/category")
	ResponseEntity<Void> updateCategory(@RequestBody CategoryRequest categoryRequest) {
		categoryService.updateCategory(categoryRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "updating one category");
		headers.add("desc", "update method called");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}

//	    http://localhost:8084/catalog-service/v1/category/categoryId/2
	@DeleteMapping("/category/categoryId/{categoryId}")
	ResponseEntity<Void> deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategory(categoryId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deleting one category by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	}

//	    http://localhost:8084/catalog-service/v1/category/categoryId/1
	@GetMapping("/category/categoryId/{categoryId}")
	ResponseEntity<CategoryResponse> getById(@PathVariable int categoryId) {
		CategoryResponse category = categoryService.getById(categoryId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting one category by id");
		return ResponseEntity.ok().headers(headers).body(category);
	}

}

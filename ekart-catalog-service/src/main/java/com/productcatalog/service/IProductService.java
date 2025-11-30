package com.productcatalog.service;

import java.util.List;

import com.productcatalog.exception.ProductNotFoundException;
import com.productcatalog.model.dtos.ProductRequest;
import com.productcatalog.model.dtos.ProductResponse;

public interface IProductService {
	// CRUD operation
	void addProduct(ProductRequest productRequest);
	void updateProduct(ProductRequest productRequest);
	void deleteProduct(int productId);
	ProductResponse getById(int productId) throws ProductNotFoundException;
	List<ProductResponse> getAll();

	// Derived Queries
	List<ProductResponse> getByBrand(String brand) throws ProductNotFoundException;
	List<ProductResponse> getByCategory(String category) throws ProductNotFoundException;
	List<ProductResponse> getByCatLessPrice(String category, double price) throws ProductNotFoundException;

}

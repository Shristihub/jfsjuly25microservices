package com.productcatalog.service;

import com.productcatalog.model.dtos.BrandRequest;
import com.productcatalog.model.dtos.BrandResponse;

public interface IBrandService {
	
	//CRUD operation
	void addBrand(BrandRequest brandRequest);
	void updateBrand(BrandRequest brandRequest);
	void deleteBrand(int brandId);
	BrandResponse getById(int brandId) ;
	

}










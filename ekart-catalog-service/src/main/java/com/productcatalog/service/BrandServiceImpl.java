package com.productcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.exception.BrandNotFoundException;
import com.productcatalog.model.dtos.BrandRequest;
import com.productcatalog.model.dtos.BrandResponse;
import com.productcatalog.model.entities.Brand;
import com.productcatalog.repository.IBrandRepository;
import com.productcatalog.util.ProductMapper;

@Service
public class BrandServiceImpl implements IBrandService{
	@Autowired
	private IBrandRepository brandRepository;
	@Autowired
	private ProductMapper mapper;

	
	@Override
	public BrandResponse getById(int brandId) throws BrandNotFoundException {
		Brand brand = brandRepository.findById(brandId)
		  .orElseThrow(()-> new BrandNotFoundException("invalid brand"));
		return mapper.toBrand(brand);
	}


	@Override
	public void addBrand(BrandRequest brandRequest) {
		brandRepository.save(mapper.toBrandEntity(brandRequest));
	}

	@Override
	public void updateBrand(BrandRequest brandRequest) {
		brandRepository.save(mapper.toBrandEntity(brandRequest));
		
	}


	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
		
	}

	
}

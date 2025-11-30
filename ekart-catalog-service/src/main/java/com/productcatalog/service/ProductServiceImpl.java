package com.productcatalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.exception.ProductNotFoundException;
import com.productcatalog.model.dtos.ProductRequest;
import com.productcatalog.model.dtos.ProductResponse;
import com.productcatalog.model.entities.Product;
import com.productcatalog.repository.IProductRepository;
import com.productcatalog.util.ProductMapper;
 
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ProductMapper mapper;

	@Override
	public void addProduct(ProductRequest productRequest) {

		Product savedProduct = productRepository.save(mapper.toProductEntity(productRequest));

	}

	@Override
	public void updateProduct(ProductRequest productRequest) {
		// product should have id in it - then updates it
		productRepository.save(mapper.toProductEntity(productRequest));
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public ProductResponse getById(int productId) {

		// get the value if present or throw exception
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("invalid id"));
		return mapper.toProductResponse(product);

	}

	@Override
	public List<ProductResponse> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> mapper.toProductResponse(product))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductResponse> getByBrand(String brand) throws ProductNotFoundException {
		List<Product> products = productRepository.findByBrand(brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this brand not available");
		return products.stream().map(product -> mapper.toProductResponse(product))
				.sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName())).collect(Collectors.toList());
	}

	@Override
	public List<ProductResponse> getByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategory(category);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this category not available");
		return products.stream().map(product -> mapper.toProductResponse(product))
				.sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName())).collect(Collectors.toList());
	}

	@Override
	public List<ProductResponse> getByCatLessPrice(String category, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategoryPrice(category, price);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this category and less price not available");
		return products.stream().map(product -> mapper.toProductResponse(product))
				.sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName())).collect(Collectors.toList());
	}

}

package com.productcatalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.exception.ProductNotFoundException;
import com.productcatalog.feign.IProductInventoryFeign;
import com.productcatalog.model.dtos.InventoryRequest;
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
	@Autowired
	private IProductInventoryFeign inventoryFeign;

	@Override
	public void addProduct(ProductRequest productRequest) {

		Product savedProduct = productRepository.save(mapper.toProductEntity(productRequest));
		// get the stock and the productId;
		int stock = productRequest.getStock();
		int productId = savedProduct.getProductId();
		// create an inventoryrequest and set the values
		InventoryRequest request = new InventoryRequest();
		request.setProductId(productId);
		request.setStock(stock);

		// make an api call to product-inventory to store stock - using feign
		inventoryFeign.addStock(request);
		System.out.println("added");

	}

	@Override
	public void updateProduct(ProductRequest productRequest) {
		// product should have id in it - then updates it
		Product updatedProduct = productRepository.save(mapper.toProductEntity(productRequest));
		// get the stock and the productId;
		int stock = productRequest.getStock();
		int productId = updatedProduct.getProductId();
		// create an inventoryrequest and set the values
		InventoryRequest request = new InventoryRequest();
		request.setProductId(productId);
		request.setStock(stock);

		// make an api call to product-inventory to store stock - using feign
		inventoryFeign.updateStock(request);
		System.out.println("updated");
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
		System.out.println(products);
		return products.stream().map(product -> mapper.toProductResponse(product)).collect(Collectors.toList());
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

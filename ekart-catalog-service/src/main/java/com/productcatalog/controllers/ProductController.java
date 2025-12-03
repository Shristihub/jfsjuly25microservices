package com.productcatalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.dtos.ProductRequest;
import com.productcatalog.model.dtos.ProductResponse;
import com.productcatalog.service.IProductService;

@RestController
@RequestMapping("/catalog-service/v1")
public class ProductController {

	@Autowired
	private IProductService productService;
//	@Value("${message}")
//	private String mymessage;
//
//	@GetMapping("/show-message")
//	public String printMessage() {
//		return mymessage;
//	}

//		http://localhost:8081/catalog-service/v1/products
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductRequest productRequest) {
		productService.addProduct(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//		http://localhost:8081/catalog-service/v1/products
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductRequest productRequest) {
		productService.updateProduct(productRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "updating one product");
		headers.add("desc", "update method called");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}

//	    http://localhost:8081/catalog-service/v1/products/productId/2
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deleting one product by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	}

//	    http://localhost:8081/catalog-service/v1/products/productId/1
	@GetMapping("/products/productId/{productId}")
	ResponseEntity<ProductResponse> getById(@PathVariable int productId) {
		ProductResponse productResponse = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting one product by id");
		return ResponseEntity.ok().headers(headers).body(productResponse);
	}

//		 http://localhost:8081/catalog-service/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductResponse>> getAll() {
		List<ProductResponse> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all products");
		return ResponseEntity.ok().headers(headers).body(products);
	}

//		 http://localhost:8081/catalog-service/v1/products/brand/Samsung
	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<ProductResponse>> getByBrand(@PathVariable String brand) {
		List<ProductResponse> products = productService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all products by brand");
		return new ResponseEntity<List<ProductResponse>>(products, headers, HttpStatus.OK.value());
	}

//		 http://localhost:8081/catalog-service/v1/products/category?category=electronics
	@GetMapping("/products/category")
	ResponseEntity<List<ProductResponse>> getByCategory(@RequestParam String category) {
		List<ProductResponse> products = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all products by category");
		return ResponseEntity.ok().headers(headers).body(products);

	}

//		http://localhost:8081/catalog-service/v1/products/category/Electronics/price/20000
	@GetMapping("/products/category/{category}/price/{price}")
	ResponseEntity<List<ProductResponse>> getByCatLessPrice(@PathVariable String category, @PathVariable double price) {
		List<ProductResponse> products = productService.getByCatLessPrice(category, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all products by category and less price");
		return ResponseEntity.ok().headers(headers).body(products);
	}

}

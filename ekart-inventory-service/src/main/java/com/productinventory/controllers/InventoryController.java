package com.productinventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productinventory.model.InventoryRequest;
import com.productinventory.service.IInventoryService;

@RestController
@RequestMapping("/inventory-service/v1")
public class InventoryController {
	
	@Autowired
	IInventoryService inventoryService;
	
	// http://localhost:8087/inventory-service/v1/product-inventory
	@PostMapping("/product-inventory")
	ResponseEntity<Void> addStock(@RequestBody InventoryRequest inventoryRequest) {
		inventoryService.addStock(inventoryRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	http://localhost:8087/inventory-service/v1/product-inventory
	@PutMapping("/product-inventory")
	ResponseEntity<Void> updateStock(@RequestBody InventoryRequest inventoryRequest) {
		inventoryService.updateStock(inventoryRequest);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
//	http://localhost:8087/inventory-service/v1/product-inventory/productId/1
	@GetMapping("/product-inventory/productId/{productId}")
	ResponseEntity<Integer> checkExistingStock(@PathVariable int productId) {
		int stock = inventoryService.checkStock(productId);
		return ResponseEntity.ok(stock);
	}
}

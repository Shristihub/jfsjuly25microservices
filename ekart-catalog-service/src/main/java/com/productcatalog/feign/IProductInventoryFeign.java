package com.productcatalog.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productcatalog.model.dtos.InventoryRequest;

//this is the client for catalog-service
//this is a declarative client
//the implementation will be created during the runtime
//pass the name of the service to which you want to connect

@FeignClient(name = "product-inventory")
public interface IProductInventoryFeign {
	

//	http://localhost:8087/inventory-service/v1/product-inventory
	@PostMapping("/inventory-service/v1/product-inventory")
	ResponseEntity<Void> addStock(@RequestBody InventoryRequest inventoryRequest) ;
	
	@PutMapping("/inventory-service/v1/product-inventory")
	ResponseEntity<Void> updateStock(@RequestBody InventoryRequest inventoryRequest) ;
	
	
}

	
	
	
	
	
	
	
	
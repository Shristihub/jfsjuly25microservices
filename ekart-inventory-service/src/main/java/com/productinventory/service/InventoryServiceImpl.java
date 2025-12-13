package com.productinventory.service;

import org.springframework.stereotype.Service;

import com.productinventory.exceptions.InvalidProductIdException;
import com.productinventory.model.Inventory;
import com.productinventory.model.InventoryRequest;
import com.productinventory.repository.IInventoryRepository;
import com.productinventory.util.InventoryMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryServiceImpl implements IInventoryService{
	
	final IInventoryRepository inventoryRepository;
	final InventoryMapper mapper;
	
	@Override
	public void addStock(InventoryRequest inventoryRequest) {
	  inventoryRepository.save(mapper.toInventoryEntity(inventoryRequest));	
	}

	@Override
	public void updateStock(InventoryRequest inventoryRequest) {
		// get the productId and stock from the request
		int productId =   inventoryRequest.getProductId();
		int newstock = inventoryRequest.getStock(); //50
		
		// check if the productId exists in the db
		// if yes get the inventory record and update it
		Inventory inventory = inventoryRepository.getByProductId(productId)
		// or else create a new inventory object and save as new record		
				.orElseGet(()-> new Inventory());
		System.out.println(inventory);		
		// get the old stock
		int oldstock =inventory.getStock();
		
		// add the newstock to oldstock and set the stock to the inventory
		inventory.setStock(oldstock+newstock);
		// set the productId in case of new Inventory
		inventory.setProductId(productId);
		System.out.println(inventory);
		inventoryRepository.save(inventory);
		
	}

	@Override
	public int checkStock(int productId) {
		Inventory inventory = inventoryRepository.getByProductId(productId)
				.orElseThrow(()->new InvalidProductIdException("invalid Id"));
		return inventory.getStock();
	}

}

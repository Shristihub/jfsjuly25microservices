package com.productinventory.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productinventory.model.Inventory;
import com.productinventory.model.InventoryRequest;

@Component
public class InventoryMapper {

	@Autowired
	private ModelMapper mapper;
	
	
	public Inventory toInventoryEntity(InventoryRequest inventoryRequest){
		return mapper.map(inventoryRequest, Inventory.class);
	}
	
	
	
	
	
}

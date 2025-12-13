package com.productinventory.service;

import com.productinventory.model.InventoryRequest;

public interface IInventoryService {

	void addStock(InventoryRequest inventoryRequest);
	void updateStock(InventoryRequest inventoryRequest);
	int checkStock(int productId);
}

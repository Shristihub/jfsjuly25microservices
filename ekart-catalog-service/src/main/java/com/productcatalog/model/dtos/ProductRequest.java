package com.productcatalog.model.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {

	private String productName;
	private Integer productId;
	private double price;
	private FeaturesRequest features; // one to one
	private List<OffersRequest> offers; // one to many
	private BrandRequest brand; // many to one
	private List<CategoryRequest> categories;
	private List<String> paymentModes; // COD,UPI,CREDITCARD,DEBITCARD
	private List<String> deliveryTypes; // standard, prime,free
	
	private int stock; // this is for inventoryservice

}

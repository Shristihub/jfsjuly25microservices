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
public class ProductResponse {

	private String productName;
	private Integer productId;
	private double price;
	private FeaturesResponse features;
	private List<OffersResponse> offers;
	private BrandResponse brand;
	private List<CategoryResponse> categories;
	private List<String> paymentModes; // COD,UPI,CREDITCARD,DEBITCARD
	private List<String> deliveryTypes; // standard, prime,free
}

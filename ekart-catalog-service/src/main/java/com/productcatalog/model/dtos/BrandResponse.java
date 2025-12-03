package com.productcatalog.model.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "products")
public class BrandResponse {

	private String brandName;
	private Integer brandId;
	@JsonIgnore
	private List<ProductResponse> products;
}

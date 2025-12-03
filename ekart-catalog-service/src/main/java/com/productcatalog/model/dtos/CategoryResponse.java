package com.productcatalog.model.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponse {
	private Integer categoryId;
	private String categoryName;
	@JsonIgnore
	private List<ProductResponse> products;
}

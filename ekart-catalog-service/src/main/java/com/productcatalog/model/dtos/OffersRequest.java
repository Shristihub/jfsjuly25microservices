package com.productcatalog.model.dtos;

import com.productcatalog.model.enums.OffersType;

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
public class OffersRequest {
	private OffersType offersType; //cashback, bankoffer, partneroffer
	private Integer offersId;
	private String description;

}










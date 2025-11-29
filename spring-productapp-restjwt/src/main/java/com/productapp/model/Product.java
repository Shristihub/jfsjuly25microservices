package com.productapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class Product {

	private String productName;
	@Id
	@GeneratedValue(generator = "prod_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "prod_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1)
	private Integer productId;
	private double price;
	
	//ave features before saving product entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "features_id") // to give a diff
	private Features features;
	
	
	
	
}

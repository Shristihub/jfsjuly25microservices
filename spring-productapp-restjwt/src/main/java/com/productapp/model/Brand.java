package com.productapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Brand {

	private String brandName;
	@Id
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq",initialValue = 100,allocationSize = 1)
	private Integer brandId;
	
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
}

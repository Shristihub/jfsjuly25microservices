package com.productapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Features {

	private String material;
	@Id
	@GeneratedValue(generator = "features_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "features_gen",sequenceName = "features_seq",initialValue = 10,allocationSize = 1)
	private Integer featuresId;
	private String color;
	
	
}

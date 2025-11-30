package com.productcatalog.model.entities;

import com.productcatalog.model.enums.OffersType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Offers {
	@Enumerated(EnumType.STRING)
	private OffersType offersType; //cashback, bankoffer, partneroffer
	@Id
	@GeneratedValue(generator = "offers_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offers_gen",sequenceName = "offers_seq",initialValue = 50,allocationSize = 1)
	private Integer offersId;
	private String description;

}










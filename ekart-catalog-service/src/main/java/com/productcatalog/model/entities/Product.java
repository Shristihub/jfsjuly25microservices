package com.productcatalog.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	//save features before saving product entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "features_id") // to give a different column name
	private Features features;
	
	//save features before saving product entity
	@OneToMany(cascade = CascadeType.ALL)
	//to add product_id to offers table
	@JoinColumn(name="product_id")
	private List<Offers> offers;
	
	@ManyToOne
	@JoinColumn(name = "brand_id") // to give a different column name
	private Brand brand;
	@ManyToMany
	//to get a proper table name
	@JoinTable(
	        name="product_category",
	        joinColumns=@JoinColumn(name="product_id"),
	        inverseJoinColumns= @JoinColumn(name="category_id")
	    )
	private List<Category> categories;
	
	@ElementCollection
	@CollectionTable(name = "payment",joinColumns = @JoinColumn(name="product_id"))
	private List<String> paymentModes; //COD,UPI,CREDITCARD,DEBITCARD
	
	@ElementCollection
	@CollectionTable(name = "delivery",joinColumns = @JoinColumn(name="product_id"))
	private List<String> deliveryTypes; //standard, prime,free
	
	
	
	
	
	
}

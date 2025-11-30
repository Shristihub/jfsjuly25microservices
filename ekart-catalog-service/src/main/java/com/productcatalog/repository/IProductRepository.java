package com.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productcatalog.model.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

	@Query("from Product p join p.brand b where b.brandName=?1")
	List<Product> findByBrand(String brand);
	
	@Query("from Product p join p.categories c where c.categoryName=?1")
	List<Product> findByCategory(String category);

	@Query("from Product p join p.categories c where c.categoryName=?1and p.price<=?2 ")
	List<Product> findByCategoryPrice(String category, double price);

}

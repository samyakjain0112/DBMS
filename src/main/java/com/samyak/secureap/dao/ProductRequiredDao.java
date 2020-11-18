package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.ProductRequired;

public interface ProductRequiredDao {

	int save(ProductRequired productRequired);
	boolean check(ProductRequired productRequired);
	void delete(int productId);
	List<ProductRequired> getAllProducts();
}

package com.samyak.secureap.dao;

import java.sql.Date;
import java.util.List;
import com.samyak.secureap.models.Product;

public interface ProductDao {

	int save(Product product);
	boolean check(Product product);
	void delete(int productId);
	List<Product> getAllProducts();
	List<Product> getAllProductsByDistributerId(int distributerId);
}

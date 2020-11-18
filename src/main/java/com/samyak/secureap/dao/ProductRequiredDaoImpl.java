package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Product;
import com.samyak.secureap.models.ProductRequired;

@Repository
public class ProductRequiredDaoImpl implements ProductRequiredDao {
	public ProductRequiredDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(ProductRequired productRequired) {
		try
	{
			String sql = "select * from ProductsRequired where productId=?";
			ProductRequired prodReq = (ProductRequired) jdbcTemplate.queryForObject(sql, new Object[] { productRequired.getProductId()},
					new BeanPropertyRowMapper<>(ProductRequired.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
		
		String sql = "insert into ProductsRequired (productId, quantity, clientId ) values(?, ?, ?)";
		jdbcTemplate.update(sql, productRequired.getProductId(), productRequired.getQuantity(), productRequired.getClientId());
		
		return 1;
    }
		return 0;
		
	}
	
	@Override
	public boolean check(ProductRequired productRequired){
		//loginAccount.setRole("ROLE_"+ loginAccount.getRole());
		try
	{
			String sql = "select * from ProductsRequired where productId=?";
			ProductRequired prodReq = (ProductRequired) jdbcTemplate.queryForObject(sql, new Object[] {productRequired.getProductId() },
					new BeanPropertyRowMapper<>(ProductRequired.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
        return false;
    }
		return true;
}
	
	
	@Override
	public void delete(int productId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "Delete from ProductsRequired where productId=?";
		jdbcTemplate.update(sql,productId );
	}	
	@Override
    public List<ProductRequired> getAllProducts(){
        String sql="select * from ProductsRequired";
        return jdbcTemplate.query(sql,
        new BeanPropertyRowMapper<>(ProductRequired.class));


    }

}

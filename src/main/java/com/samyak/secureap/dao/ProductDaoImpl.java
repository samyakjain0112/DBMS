package com.samyak.secureap.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Appointment;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Product;

	@Repository
	public class ProductDaoImpl implements ProductDao {
		public ProductDaoImpl() {
			// TODO Auto-generated constructor stub
		}

		@Autowired
		JdbcTemplate jdbcTemplate;
		
		@Override
		public int save(Product product) {
			try
		{
				String sql = "select * from Product where productId=?";
				Product prod = (Product) jdbcTemplate.queryForObject(sql, new Object[] { product.getProductId()},
						new BeanPropertyRowMapper<>(Product.class));
				 
		}
			
		catch (EmptyResultDataAccessException e) {
			
			String sql = "insert into Product (productId, mrp, discount, expiryDate, companyName, clientId , distributerId, customerId ) values(?, ?, ?, ?,?,?,?,?)";
			jdbcTemplate.update(sql, product.getProductId(), product.getMrp(), product.getDiscount(),product.getExpiryDate(), product.getCompanyName(), product.getClientId()
					,product.getDistributerId(), product.getCustomerId());
			
			return 1;
	    }
			return 0;
			
		}
		
		@Override
		public boolean check(Product product){
			//loginAccount.setRole("ROLE_"+ loginAccount.getRole());
			try
		{
				String sql = "select * from Product where productId=?";
				Product prod = (Product) jdbcTemplate.queryForObject(sql, new Object[] {product.getProductId() },
						new BeanPropertyRowMapper<>(Product.class));
				 
		}
			
		catch (EmptyResultDataAccessException e) {
	        return false;
	    }
			return true;
	}
		
		
		@Override
		public void delete(int productId) {
			
			//customer.setRole("ROLE_"+ loginAccount.getRole());
			String sql = "Delete from Product where productId=?";
			jdbcTemplate.update(sql,productId );
		}	
		@Override
	    public List<Product> getAllProducts(){
	        String sql="select * from Product";
	        return jdbcTemplate.query(sql,
	        new BeanPropertyRowMapper<>(Product.class));
	    }
		
		
		@Override
	    public List<Product> getAllProductsByDistributerId(int distributerId){
	        String sql="select * from Product where distributerId=?";
	        return jdbcTemplate.query(sql,new Object[] {distributerId},
	        new BeanPropertyRowMapper<>(Product.class));
	        
	    }

}

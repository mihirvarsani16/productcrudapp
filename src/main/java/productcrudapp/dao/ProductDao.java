package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import productcrudapp.model.Product;

@Component
public class ProductDao {
     @Autowired
	 private HibernateTemplate hibernateTemplate;
     
     //create
     @Transactional
     public void createProduct(Product product) {
    	 
    
    	 
    	 this.hibernateTemplate.saveOrUpdate(product);
     }
	 
     //get all product


 	public List<Product> getProducts() {
 		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
 	    return products;
 	}
	 
	 //delete the singal product
	 @Transactional
	 public void delectProduct(int id) {
		Product p = this.hibernateTemplate.load(Product.class, id); 
		 this.hibernateTemplate.delete(p);
	 }
	 
	 
	 //select one product
	 
	 public Product getProduct(int id) {
		 return this.hibernateTemplate.get(Product.class, id);
	 }

}

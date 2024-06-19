package com.example.demospring.service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospring.dao.IProductDAO;
import com.example.demospring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public final IProductDAO productDAO;
@Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void saveProduct(Product product){
     productDAO.saveProduct(product);
    }

    public Product getProductById(Integer id){
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProduct(){
       return productDAO.getAllProduct();
    }

    public  void updateProduct(Product product){
        productDAO.updateProduct(product);
    }
    public void deleteProduct(Integer id) {
        productDAO.deleteProduct(id);
    }


}

package com.eriaothienopinyi.srpingbootcrudexample.service;

import com.eriaothienopinyi.srpingbootcrudexample.model.Product;
import com.eriaothienopinyi.srpingbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired //Inject the repository into the service to allow interaction
    private ProductRepository productRepository;

    //Save (post) a single product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    //Save (post) a list of products
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    //Retrieve (get) a list of products
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}

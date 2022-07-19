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
/*
GET methods
 */
    //Save (post) a single product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    //Save (post) a list of products
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
/*
POST methods
 */
    //Retrieve (get) a list of products
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    //Retrieve (get) a single product, by id
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    //Retrieve (get) a product by some other parameter other than id e.g. name
    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }
/*
DELETE methods
 */
    public String deleteProduct(int id){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null){
            productRepository.deleteById(id);
            return "Product " + id + " deleted successfully";
        }else{
            return "No such product " + id + " found!";
        }
    }
/*
UPDATE (PUT) methods
 */
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if(existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }else{
            return null;
        }
    }
}

package com.eriaothienopinyi.srpingbootcrudexample.controller;

import com.eriaothienopinyi.srpingbootcrudexample.model.Product;
import com.eriaothienopinyi.srpingbootcrudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    //Create the Endpoints
/*
POST
 */
    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/add-products")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
/*
GET
 */
    @GetMapping("/find-products")
    public List<Product> findProducts(){
        return productService.getProducts();
    }
    @GetMapping("/find-products/id/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/find-products/name/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

/*
PUT (Update)
 */
    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

/*
DELETE
 */
    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}

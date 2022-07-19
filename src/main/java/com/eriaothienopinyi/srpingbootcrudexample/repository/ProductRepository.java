package com.eriaothienopinyi.srpingbootcrudexample.repository;

import com.eriaothienopinyi.srpingbootcrudexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}

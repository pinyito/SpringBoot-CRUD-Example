package com.eriaothienopinyi.srpingbootcrudexample.repository;

import com.eriaothienopinyi.srpingbootcrudexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

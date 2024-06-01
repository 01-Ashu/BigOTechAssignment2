package com.Assignment.Product.Repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment.Product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

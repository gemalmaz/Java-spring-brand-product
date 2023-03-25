package com.kodlama.productManager.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.productManager.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

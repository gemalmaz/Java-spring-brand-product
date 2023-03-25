package com.kodlama.productManager.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.productManager.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}

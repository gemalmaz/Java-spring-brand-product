package com.kodlama.productManager.business.conretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.productManager.business.abstracts.BrandServices;
import com.kodlama.productManager.business.requests.AddBrandRequest;
import com.kodlama.productManager.business.requests.AddProductRequest;
import com.kodlama.productManager.business.requests.DeleteBrandRequest;
import com.kodlama.productManager.business.requests.UpdateBrandRequest;
import com.kodlama.productManager.business.responses.GetAllBrandResponses;
import com.kodlama.productManager.business.responses.GetAllProductResponses;
import com.kodlama.productManager.dataAcces.BrandRepository;
import com.kodlama.productManager.entities.concretes.Brand;
@Service
public class BrandManager implements BrandServices{
   private BrandRepository brandRepository;
   
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
	
	this.brandRepository = brandRepository;
}


	@Override
	public List<GetAllBrandResponses> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandResponses> brandResponses = new ArrayList<GetAllBrandResponses>();
		for(Brand brand : brands) {
		GetAllBrandResponses responsesItem = new GetAllBrandResponses();
		responsesItem.setId(brand.getId());
		responsesItem.setBrandName(brand.getBrandName());
		brandResponses.add(responsesItem);
		}
		return brandResponses;
	}


	@Override
	public void add(AddBrandRequest addBrandRequest) {
		Brand brand = new Brand();
		brand.setBrandName(addBrandRequest.getBrandName());
		brandRepository.save(brand);
	}


	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = new Brand();
		brand.setId(deleteBrandRequest.getId());
		this.brandRepository.delete(brand);
		
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
	 Brand brand = brandRepository.findById(updateBrandRequest.getId()).get();
			 brand.setBrandName(updateBrandRequest.getBrandName());
	 brandRepository.save(brand);
		
	}



	
}

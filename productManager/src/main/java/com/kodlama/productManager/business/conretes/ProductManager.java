package com.kodlama.productManager.business.conretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.productManager.business.abstracts.ProductService;
import com.kodlama.productManager.business.requests.AddProductRequest;
import com.kodlama.productManager.business.requests.DeleteProductRequest;
import com.kodlama.productManager.business.requests.UpdateProductRequest;
import com.kodlama.productManager.business.responses.GetAllProductResponses;
import com.kodlama.productManager.dataAcces.BrandRepository;
import com.kodlama.productManager.dataAcces.ProductRepository;
import com.kodlama.productManager.entities.concretes.Brand;
import com.kodlama.productManager.entities.concretes.Product;
@Service
public class ProductManager implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductManager(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	@Override
	public List<GetAllProductResponses> getAll() {
		List<Product> products = productRepository.findAll();
		//boş liste oluşturduk
		
		List<GetAllProductResponses> productResponses = new ArrayList<GetAllProductResponses>();
		//forla ana listeyi dolaşıyoruz
		for(Product product : products) {
			GetAllProductResponses responsesItem = new GetAllProductResponses();
			responsesItem.setId(product.getId());
			responsesItem.setProductName(product.getProductName());
			productResponses.add(responsesItem);
		}
		return productResponses;
	}

	@Override
	public void add(AddProductRequest addProductRequest) {
		Product product = new Product();
		product.setProductName(addProductRequest.getProductName());
		this.productRepository.save(product);
		
	}

	@Override
	public void delete(DeleteProductRequest deleteProductRequest) {
		Product product = new Product();
		product.setId(deleteProductRequest.getId());
		this.productRepository.delete(product);
	}

	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = productRepository.findById(updateProductRequest.getId()).get();		
		product.setProductName(updateProductRequest.getProductName());
			productRepository.save(product);
		
	}

}

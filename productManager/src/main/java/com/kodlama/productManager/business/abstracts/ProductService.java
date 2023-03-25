package com.kodlama.productManager.business.abstracts;

import java.util.List;

import com.kodlama.productManager.business.requests.AddProductRequest;
import com.kodlama.productManager.business.requests.DeleteProductRequest;
import com.kodlama.productManager.business.requests.UpdateProductRequest;
import com.kodlama.productManager.business.responses.GetAllProductResponses;
import com.kodlama.productManager.entities.concretes.Product;

public interface ProductService {
	List<GetAllProductResponses> getAll(); 
  void add(AddProductRequest addProductRequest);
  void delete(DeleteProductRequest deleteProductRequest);
  void update(UpdateProductRequest updateProductRequest);
}

package com.kodlama.productManager.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.productManager.business.abstracts.ProductService;
import com.kodlama.productManager.business.requests.AddProductRequest;
import com.kodlama.productManager.business.requests.DeleteProductRequest;
import com.kodlama.productManager.business.requests.UpdateProductRequest;
import com.kodlama.productManager.business.responses.GetAllProductResponses;
import com.kodlama.productManager.entities.concretes.Product;
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	public ProductsController(ProductService productService) {
		
		this.productService = productService;
	}
	@GetMapping("/getAll")
	public  List<GetAllProductResponses> getAll(){
		return productService.getAll();
		
	}
	@PostMapping("/add")
	public void add(@RequestBody AddProductRequest addProductRequest) {
		this.productService.add(addProductRequest);
	}
	@DeleteMapping("/delete")
	public void delete( DeleteProductRequest deleteProductRequest ) {
		this.productService.delete(deleteProductRequest);
	}
	@PutMapping("/update")
	public void update(UpdateProductRequest updateProductRequest) {
		this.productService.update(updateProductRequest);
	}

}

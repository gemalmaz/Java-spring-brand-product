package com.kodlama.productManager.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.productManager.business.abstracts.BrandServices;
import com.kodlama.productManager.business.requests.AddBrandRequest;
import com.kodlama.productManager.business.requests.DeleteBrandRequest;
import com.kodlama.productManager.business.requests.UpdateBrandRequest;
import com.kodlama.productManager.business.responses.GetAllBrandResponses;
@RestController
@RequestMapping("/api/brandss")

public class BrandControllers {
	private BrandServices brandServices;

	public BrandControllers(BrandServices brandServices) {
		this.brandServices = brandServices;
	}
	@GetMapping("/getAll")
	public List<GetAllBrandResponses> getAll(){
		return brandServices.getAll();
		}
	@PostMapping("/add")
	public void add(AddBrandRequest addBrandRequest) {
		this.brandServices.add(addBrandRequest);
	}
	@PutMapping("/update")
	public void update(UpdateBrandRequest updateBrandRequest) {
		this.brandServices.update(updateBrandRequest);
	}
	@DeleteMapping
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		this.brandServices.delete(deleteBrandRequest);
	}

}

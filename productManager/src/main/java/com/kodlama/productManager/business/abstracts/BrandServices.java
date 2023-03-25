package com.kodlama.productManager.business.abstracts;

import java.util.List;

import com.kodlama.productManager.business.requests.AddBrandRequest;
import com.kodlama.productManager.business.requests.AddProductRequest;
import com.kodlama.productManager.business.requests.DeleteBrandRequest;
import com.kodlama.productManager.business.requests.UpdateBrandRequest;
import com.kodlama.productManager.business.responses.GetAllBrandResponses;

public interface BrandServices {

	List<GetAllBrandResponses> getAll();
	void add(AddBrandRequest addBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	void update (UpdateBrandRequest updateBrandRequest);
	
}

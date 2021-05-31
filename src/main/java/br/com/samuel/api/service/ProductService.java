package br.com.samuel.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.samuel.api.model.request.ProductRequest;
import br.com.samuel.api.model.response.ProductResponse;

public interface ProductService {
	
	ProductResponse create(ProductRequest request);
	
	Optional<ProductResponse> get(Long id);
	
	Optional<ProductResponse> update(Long id, ProductRequest request);
	
	Optional<ProductResponse> delete(Long id);
	
	Page<ProductResponse> getAll(Pageable pageable);
	
	
	
	

}

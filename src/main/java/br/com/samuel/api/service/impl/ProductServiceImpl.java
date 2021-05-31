package br.com.samuel.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.samuel.api.model.request.ProductRequest;
import br.com.samuel.api.model.response.ProductResponse;
import br.com.samuel.api.persistence.entity.Product;
import br.com.samuel.api.persistence.repository.ProductRepository;
import br.com.samuel.api.service.Mapper;
import br.com.samuel.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

    @Autowired
    private Mapper<ProductRequest, Product> requestMapper;

    @Autowired
    private Mapper<Product, ProductResponse> responseMapper;
    
    

	@Override
	public ProductResponse create(ProductRequest request) {
		Product product=requestMapper.map(request);
		
		return repository.saveAndFlush(product).map((Product input )-> responseMapper.map(input));
	}

	@Override
	public Optional<ProductResponse> get(Long id) {
		return repository.findById(id).map(this.responseMapper::map);
	}
	@Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(produtcs -> this.responseMapper.map(produtcs));
    }


	@Override
	public Optional<ProductResponse> update(Long id, ProductRequest request) {
		 Product update = this.requestMapper.map(request);

	        return repository.findById(id)
	                .map(product -> {
	                    product.setName(update.getName());
	                    product.setValue(update.getValue());
	                    product.setQuantity(update.getQuantity());

	                    return this.responseMapper.map(repository.saveAndFlush(product));
	                });
	    }
	

	@Override
	public Optional<ProductResponse> delete(Long id) {
		Optional<ProductResponse> optional=repository.findById(id).map(this.responseMapper::map);
		this.repository.existsById(id);
		return optional;
		

	}
	
	

}

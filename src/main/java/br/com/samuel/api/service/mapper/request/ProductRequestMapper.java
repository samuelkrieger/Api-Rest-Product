package br.com.samuel.api.service.mapper.request;

import org.springframework.stereotype.Component;

import br.com.samuel.api.model.request.ProductRequest;
import br.com.samuel.api.persistence.entity.Product;
import br.com.samuel.api.service.Mapper;

@Component
public class ProductRequestMapper implements Mapper<ProductRequest, Product> {
	
	@Override
    public Product map(ProductRequest input) {
        if(input == null){
            return null;
        }

        Product product = new Product();
        product.setName(input.getName());
        product.setValue(input.getValue());
        product.setQuantity(input.getQuantity());
      
     

        return product;
    }

}

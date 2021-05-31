package br.com.samuel.api.service.mapper.response;

import org.springframework.stereotype.Component;

import br.com.samuel.api.model.response.ProductResponse;
import br.com.samuel.api.persistence.entity.Product;
import br.com.samuel.api.service.Mapper;


@Component
public class ProductResponseMapper implements Mapper<Product,ProductResponse> {
	
	@Override
    public ProductResponse map(Product input) {
        if(input == null){
            return null;
        }

        ProductResponse  product = new ProductResponse();
        product.setName(input.getName());
        product.setValue(input.getValue());
        product.setQuantity(input.getQuantity());
      
     

        return product;
    } }

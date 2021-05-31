package br.com.samuel.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuel.api.model.request.ProductRequest;
import br.com.samuel.api.model.response.ProductResponse;
import br.com.samuel.api.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("api")
@Api(value = "products")
public class ProductController {
	
	 @Autowired
	 private ProductService service;
	 
	   
		
		@PostMapping("/insert")
		public String novo(@ModelAttribute("request") ProductRequest request, BindingResult result) {
			if(result.hasErrors()) {
				return "api/insert";
			}
			
			service.create(request);
			return "redirect:/home";
		}
	 
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 @ApiOperation(
	            value = "Create Product",
	            nickname = "create",
	            notes = "Creates a new product",
	            response = ResponseEntity.class,
	            tags = {"Creation"}
	    )
	    @ApiResponses({
	            @ApiResponse(code = 201, message = "product-created", response = ResponseEntity.class),
	            @ApiResponse(code = 400, message = "product-error"),
	    })
	 public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
	        return ResponseEntity.ok(service.create(request));
	    }
	 
	 
	 
	    @GetMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    @ApiOperation(
	            value = "Find Product by Id",
	            nickname = "find",
	            notes = "Finds an existing product by id",
	            response = ResponseEntity.class,
	            tags = {"Find"}
	    )
	    @ApiResponses({
	            @ApiResponse(code = 200, message = "product-found", response = ResponseEntity.class),
	            @ApiResponse(code = 404, message = "product-not-found", response =ResponseEntity.class),
	    })
	 public ResponseEntity<ProductResponse> get(@ApiParam(name = "product id") @PathVariable("id") Long id) {
	        Optional<ProductResponse> response = service.get(id);
	        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	    
	    
	    @PutMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    @ApiOperation(
	            value = "Update Product",
	            nickname = "update",
	            notes = "Updates an existing product",
	            response =  ResponseEntity.class,
	            tags = {"Update"}
	    )
	    @ApiResponses({
	            @ApiResponse(code = 200, message = "product-updated", response =  ResponseEntity.class),
	            @ApiResponse(code = 400, message = "product-error"),
	            @ApiResponse(code = 404, message = "product-not-found", response =  ResponseEntity.class),
	    })
	 public ResponseEntity<ProductResponse> update(@ApiParam(name = "product id") @PathVariable("id") Long id, @RequestBody ProductRequest request) {
	        Optional<ProductResponse> update = service.update(id, request);
	        return update.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    @ApiOperation(
	            value = "Delete Product by Id",
	            nickname = "delete",
	            notes = "Deletes an existing product by id",
	            response =ResponseEntity.class,
	            tags = {"Delete"}
	    )
	    @ApiResponses({
	            @ApiResponse(code = 200, message = "product-found", response =ResponseEntity.class),
	            @ApiResponse(code = 404, message = "product-not-found", response = ResponseEntity.class),
	    })
	  public ResponseEntity<ProductResponse> delete(@ApiParam(name = "product id") @PathVariable Long id) {
		  	Optional<ProductResponse> delete = this.service.delete(id);
	        return delete.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	 
	 

}

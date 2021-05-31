package br.com.samuel.api.model.request;

import java.math.BigDecimal;

public class ProductRequest {
	
	private String name;
	
    private BigDecimal value;
    
    private Integer quantity;
    
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}


	
	

}

package br.com.samuel.api.persistence.entity;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "id")
    private Long id;
	
	@Column(nullable = false,name = "name")
	private String name;
	
	@Column(nullable = false,name = "value")
    private BigDecimal value;
	
	@Column(nullable = false,name = "quantity")
	private Integer quantity;
	
	public <R> R map(Function<Product, R> function){
	        return function.apply(this);
	    }
	

   
	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

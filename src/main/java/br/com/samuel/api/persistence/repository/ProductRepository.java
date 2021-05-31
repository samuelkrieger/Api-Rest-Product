package br.com.samuel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samuel.api.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

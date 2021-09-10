package com.devsuperior.dsvenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvenda.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}

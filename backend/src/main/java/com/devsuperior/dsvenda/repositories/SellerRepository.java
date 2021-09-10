package com.devsuperior.dsvenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvenda.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}

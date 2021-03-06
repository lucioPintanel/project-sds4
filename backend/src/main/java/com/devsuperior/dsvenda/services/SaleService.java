package com.devsuperior.dsvenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvenda.dto.SaleDTO;
import com.devsuperior.dsvenda.dto.SaleSuccessDTO;
import com.devsuperior.dsvenda.dto.SaleSumDTO;
import com.devsuperior.dsvenda.entities.Sale;
import com.devsuperior.dsvenda.repositories.SaleRepository;
import com.devsuperior.dsvenda.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		/*
		 * Esta solução serve para poucos dados e que vão ficar em memoria
		 */
		sellerRepository.findAll();
		Page<Sale> result = repo.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repo.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repo.successGroupedBySeller();
	}
}

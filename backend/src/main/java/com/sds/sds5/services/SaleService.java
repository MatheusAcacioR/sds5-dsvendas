package com.sds.sds5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.sds5.dto.SaleDTO;
import com.sds.sds5.dto.SaleSuccessDTO;
import com.sds.sds5.dto.SaleSumDTO;
import com.sds.sds5.entities.Sale;
import com.sds.sds5.repositories.SaleRepository;
import com.sds.sds5.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pegeable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pegeable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}

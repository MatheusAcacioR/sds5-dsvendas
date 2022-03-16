package com.sds.sds5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sds.sds5.dto.SaleSuccessDTO;
import com.sds.sds5.dto.SaleSumDTO;
import com.sds.sds5.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	// Notação para fazer uma busca de agrupamento somando as vendas de cada vendedor
	@Query("SELECT new com.sds.sds5.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	// Notação para fazer uma busca da soma das visitas e soma dos negocios fechados de cada vendedor
	@Query("SELECT new com.sds.sds5.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}

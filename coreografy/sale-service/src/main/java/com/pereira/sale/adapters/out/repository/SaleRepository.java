package com.pereira.sale.adapters.out.repository;

import com.pereira.sale.adapters.out.repository.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {

}

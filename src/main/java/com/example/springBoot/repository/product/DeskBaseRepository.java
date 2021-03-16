package com.example.springBoot.repository.product;

import com.example.springBoot.model.product.Desk;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskBaseRepository extends ProductBaseRepository<Desk> {
}

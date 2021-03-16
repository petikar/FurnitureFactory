package com.example.springBoot.repository.product;

import com.example.springBoot.model.product.Cupboard;
import org.springframework.stereotype.Repository;

@Repository
public interface CupboardBaseRepository extends ProductBaseRepository <Cupboard> {
}

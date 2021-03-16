package com.example.springBoot.repository.product;

import com.example.springBoot.model.product.Chair;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairBaseRepository extends ProductBaseRepository<Chair> {
}

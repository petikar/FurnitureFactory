package com.example.furnitureFactory.repository.product;

import com.example.furnitureFactory.model.product.Chair;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairBaseRepository extends ProductBaseRepository<Chair> {
}

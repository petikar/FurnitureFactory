package com.example.furnitureFactory.repository.sheetMaterial;

import com.example.furnitureFactory.model.material.SheetMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SheetMaterialBaseRepository<T extends SheetMaterial> extends JpaRepository<T, Integer>, SheetMaterialRepo<T> {
}

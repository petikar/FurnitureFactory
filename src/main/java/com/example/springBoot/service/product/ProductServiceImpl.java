package com.example.springBoot.service.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.example.springBoot.model.material.SheetMaterial;
import com.example.springBoot.model.product.*;
import com.example.springBoot.repository.product.ProductBaseRepository;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;

import java.util.List;

public class ProductServiceImpl<T extends Product, R extends ProductBaseRepository<T>> implements ProductService<T> {

    private R repository;
    private CommonSheetMaterialServiceImpl service;

    public ProductServiceImpl(R repository, CommonSheetMaterialServiceImpl service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void save(T newProduct) {
        T product = findByProduct(newProduct);
        if (product != null) {
            int id = product.getId();
            int countProduct = product.getProductCount();
            newProduct.setId(id);
            newProduct.setProductCount(newProduct.getProductCount() + countProduct);
        }
        repository.save(newProduct);
    }

    @Override
    public boolean create(ProductType type, Color color, int productCount) {

        List<SheetMaterial> schema = ProductSchema.setProductSchema(type, color, productCount);
        boolean b = service.findAllByProductSchema(schema);//всего ли хватает

        if (b) {
            service.deleteAllByProductSchema(schema);

            switch (type) {
                case DESK:
                    Desk desk = new Desk(color, productCount);
                    save((T) desk);
                    break;
                case CUPBOARD:
                    Cupboard cupboard = new Cupboard(color, productCount);
                    save((T) cupboard);
                    break;
                case CHAIR:
                    Chair chair = new Chair(color, productCount);
                    save((T) chair);
                    break;
            }
        }
        return b;
    }

    @Override
    //этот метод надо переписать, чтоб приводилось в соответствие с материалами
    public void update(T newProduct) {
        save(newProduct);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(int id) {
        return repository.getOne(id);
    }

    @Override
    public T findByProduct(T product) {
        return repository.findByProduct(product);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

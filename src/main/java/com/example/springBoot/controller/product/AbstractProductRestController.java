package com.example.springBoot.controller.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.example.springBoot.model.product.Product;
import com.example.springBoot.service.product.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractProductRestController<T extends Product, S extends ProductService<T>> {

    private S service;

    public AbstractProductRestController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> products = service.findAll();

        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> getProduct(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        T product = service.findById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<T> createProduct(@RequestBody T newProduct) {

        if (newProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProductType type = newProduct.getProductType();
        Color color = newProduct.getColor();
        int productCount = newProduct.getProductCount();

        boolean b = service.create(type, color, productCount);

        if (!b) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Not enough materials", "Not enough materials");
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.findByProduct(newProduct), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<T> updateProduct(
            @PathVariable Integer id,
            @RequestBody T product) {

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.update(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<T> deleteProduct(@PathVariable Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

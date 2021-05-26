package com.example.furnitureFactory.controller.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.example.furnitureFactory.model.product.Product;
import com.example.furnitureFactory.service.product.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


public abstract class AbstractProductRestController<T extends Product, S extends ProductService<T>> {

    private S service;
    //private static final Logger logger = Logger.getLogger("springBoot");

    public AbstractProductRestController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {

        //logger.fine("Method @GetMapping getAll() called in the controller, " + getClass());

        List<T> products = service.findAll();

        if (products.isEmpty()) {
            //logger.fine("Nothing found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       // logger.fine("The method getAll() returned the following values: " + products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> getProduct(@PathVariable Integer id) {

       // logger.fine("Method @GetMapping getProduct(id) was called by id=" + id + " in the controller, " + getClass());

        if (id == null) {
          //  logger.fine("id = 0, value is not valid.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        T product = service.findById(id);

        if (product == null) {
          //  logger.fine("The database doesn't contain this product");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
           // logger.fine("There is this product in the database: " + product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }


    @PostMapping()
    public ResponseEntity createProduct(@RequestBody T newProduct) {

      //  logger.fine("Method @PostMapping createProduct(newProduct) was called in the controller, " + newProduct + " " + getClass());

        if (newProduct == null) {
         //   logger.fine("There is no product in the request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProductType type = newProduct.getProductType();
        Color color = newProduct.getColor();
        int productCount = newProduct.getProductsCount();

        boolean b = service.create(type, color, productCount);

        if (!b) {
          //  logger.fine("There are not enough materials to create a " + newProduct);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Not enough materials", "There are not enough materials to create a product.");
            return new ResponseEntity("There are not enough materials to create a product.", httpHeaders, HttpStatus.BAD_REQUEST);
        }

      //  logger.fine("Product creation completed successfully");
        return new ResponseEntity<>(service.findByProduct(newProduct), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<T> updateProduct(@PathVariable Integer id, @RequestBody T product) {

      //  logger.fine("Method @PutMapping updateProduct(id, product) was called in the controller, " + product + " " + getClass());

        if (product == null) {
        //    logger.fine("There is no product in the request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        product.setId(id);
        service.update(product);

       // logger.fine("Product update completed successfully");

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<T> deleteProduct(@PathVariable Integer id) {

     //   logger.fine("Method @DeleteMapping deleteProduct(id) was called in the controller, id=" + id + " " + getClass());

        if (id == null) {
      //      logger.fine("There is no id in the request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.deleteById(id);
     //   logger.fine("Product delete completed successfully");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.springBoot.controller.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.example.springBoot.model.product.Product;
import com.example.springBoot.service.product.ProductService;
import com.sun.xml.internal.bind.api.Bridge;
import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.api.message.Header;
import com.sun.xml.internal.ws.api.message.Headers;
import com.sun.xml.internal.ws.spi.db.XMLBridge;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.List;
import java.util.Set;

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


    //если недостаточно материалов, передать это в заголовкх http
    @PostMapping()
    public ResponseEntity<T> createProduct(@RequestBody T newProduct) {

        if (newProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProductType type = newProduct.getProductType();
        Color color = newProduct.getColor();
        int productCount = newProduct.getProductCount();

        boolean b = service.create(type, color, productCount);

        //тут вернуть сообщение о том, что недостаточно материалов
        if (!b) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

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

    @DeleteMapping
    public ResponseEntity<T> deleteProduct(@PathVariable Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

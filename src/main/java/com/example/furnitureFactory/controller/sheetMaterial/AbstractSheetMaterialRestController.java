package com.example.furnitureFactory.controller.sheetMaterial;

import com.example.furnitureFactory.model.material.SheetMaterial;
import com.example.furnitureFactory.service.sheetMaterial.SheetMaterialService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractSheetMaterialRestController<T extends SheetMaterial, S extends SheetMaterialService<T>> {

    private S service;

    public AbstractSheetMaterialRestController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll(){
        List<T> materials = service.findAll();

        if (materials.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> getMaterial (@PathVariable Integer id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        T material = service.findById(id);

        if (material==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<T> saveMaterial (@RequestBody T newMaterial){

        if (newMaterial==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.save(newMaterial);

        return new ResponseEntity<>(service.findByMaterial(newMaterial), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<T> updateMaterial (
            @PathVariable Integer id,
            @RequestBody T material) {

        if (material==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        material.setId(id);
        service.update(material);

        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<T> deleteMaterial (@PathVariable Integer id) {

        if (id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.example.v1.controller;

import com.example.v1.model.Material;
import com.example.v1.service.MaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialRestController {

    private MaterialService service;

    @Autowired
    public MaterialRestController(MaterialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAll(){
        List<Material> materials = service.findAll();

        if (materials.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Material> getMaterial (@PathVariable Integer id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Material material = service.findById(id);

        if (material==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Material> saveMaterial (@RequestBody Material newMaterial){

        if (newMaterial==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.save(newMaterial);

        return new ResponseEntity<>(newMaterial, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Material> updateMaterial (
@PathVariable Integer id,
@RequestBody Material material) {

        if (material==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.update(material);

        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Material> deleteMaterial (@PathVariable Integer id) {

        if (id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

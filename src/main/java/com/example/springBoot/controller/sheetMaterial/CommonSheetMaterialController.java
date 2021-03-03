package com.example.springBoot.controller.sheetMaterial;

import java.util.List;

import com.example.springBoot.model.material.SheetMaterial;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sheet_materials")
public class CommonSheetMaterialController extends AbstractSheetMaterialRestController<SheetMaterial, CommonSheetMaterialServiceImpl> {
    public CommonSheetMaterialController(CommonSheetMaterialServiceImpl service) {
        super(service);
    }
}




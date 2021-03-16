/*package com.example.springBoot.controller;

import com.example.v1.model.Material;
import com.example.v1.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/materials")
    public String findAll(Model model){
        List<Material> materials = materialService.findAll();
        model.addAttribute("materials", materials);
        return "material/material-list";
    }

    //отдельная страница формы, куда вбиваем данные
    @GetMapping ("/material-create")
    public String createMaterialForm(Model model, Material material){
        model.addAttribute("material", material);
        return "material/material-create";
    }

    //BindingResult содержит ошибки валидации, его указываем после @Valid
    @PostMapping("/material-create")
    public String createMaterial (@Valid Material material, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "material/material-create";
        }
        materialService.save(material);
        return "redirect:/materials";
    }

    @GetMapping ("/material-delete/{id}")
    public String deleteMaterial (@PathVariable("id") int id){
        materialService.deleteById(id);
        return "redirect:/materials";
    }

    //отдельная страница формы, куда вбиваем данные
    @GetMapping("/material-update/{id}")
    public String updateMaterialForm (@PathVariable("id") int id, Model model){
        Material material = materialService.findById(id);
        model.addAttribute("material", material); //его передаём в следующий метод
        return "material/material-update";
    }


    //BindingResult содержит ошибки валидации, его указываем после @Valid
    @PostMapping("/material-update")
    public String updateMaterial(@ModelAttribute("material") @Valid Material material, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "material/material-update";
        }
        materialService.update(material);
        return "redirect:/materials";
    }
}*/

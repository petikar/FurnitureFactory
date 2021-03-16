package com.example.v1.controller;


import com.example.v1.model.User;
import com.example.v1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/user-list";
    }

    //отдельная страница формы, куда вбиваем данные
    @GetMapping ("/user-create")
    public String createUserForm(User user){
        return "user/user-create";
    }


    //BindingResult содержит ошибки валидации, его указываем после @Valid
    @PostMapping ("/user-create")
    public String createUser (@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/user-create";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping ("/user-delete/{id}")
    public String deleteUser (@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    //отдельная страница формы, куда вбиваем данные
    @GetMapping("/user-update/{id}")
    public String updateUserForm (@PathVariable("id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user); //его передаём в следующий метод
        return "/user/user-update";
    }


    //BindingResult содержит ошибки валидации, его указываем после @Valid
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/user-update";
        }
        userService.save(user);
        return "redirect:/users";
    }
}
    


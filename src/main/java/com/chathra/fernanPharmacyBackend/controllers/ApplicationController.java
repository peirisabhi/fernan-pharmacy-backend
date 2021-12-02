package com.chathra.fernanPharmacyBackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name", "Abhish");
        return "admin/dashboard";
    }

    @GetMapping("/manage-users")
    public String manageUsers(Model model){
        return "admin/manage-users";
    }


    @GetMapping("/manage-products")
    public String manageProducts(Model model){
        return "admin/manage-products";
    }
}
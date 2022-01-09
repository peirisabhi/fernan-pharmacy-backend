package com.chathra.fernanPharmacyBackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String index(Model model){
        return "admin/index";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model){
//        model.addAttribute("name", "Abhish");
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


    @GetMapping("/manage-doctors")
    public String manageDoctors(Model model){
        return "admin/manage-doctors";
    }

    @GetMapping("/manage-patients")
    public String managePatients(Model model){
        return "admin/manage-patients";
    }

    @GetMapping("/manage-orders")
    public String manageOrders(Model model){
        return "admin/manage-orders";
    }

}

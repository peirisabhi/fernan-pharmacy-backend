package com.chathra.fernanPharmacyBackend.controllers;

import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.model.Login;
import com.chathra.fernanPharmacyBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 09/01/2022
 * Time: 10:33 pm
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public ModelAndView userLogin(Model model, @ModelAttribute Login login){
        System.out.println(login.toString());
        User user = userService.userLogin(login);
        if(user == null){
            return new ModelAndView("redirect:/");
        }else {
            return new ModelAndView("redirect:/dashboard");
        }

    }

    @GetMapping("/logout")
    public ModelAndView logOut(){
        return new ModelAndView("redirect:/");
    }
}

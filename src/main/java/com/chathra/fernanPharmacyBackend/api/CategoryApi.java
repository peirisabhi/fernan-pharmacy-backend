package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Category;
import com.chathra.fernanPharmacyBackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:02 pm
 */
@RestController
@RequestMapping("/api/category")
public class CategoryApi {

    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory(){
        return categoryService.getAllCategories();
    }
}

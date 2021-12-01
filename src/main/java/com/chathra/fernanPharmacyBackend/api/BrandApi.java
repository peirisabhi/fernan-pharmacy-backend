package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Brand;
import com.chathra.fernanPharmacyBackend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:26 pm
 */
@RestController
@RequestMapping("/api/brand")
public class BrandApi {

    @Autowired
    BrandService brandService;


    @GetMapping()
    public List<Brand> getBrands(){
        return brandService.getBrandList();
    }

}

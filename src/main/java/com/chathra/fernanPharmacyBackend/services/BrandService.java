package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Brand;
import com.chathra.fernanPharmacyBackend.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:27 pm
 */
@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> getBrandList(){
       return brandRepository.findAll();
    }

}

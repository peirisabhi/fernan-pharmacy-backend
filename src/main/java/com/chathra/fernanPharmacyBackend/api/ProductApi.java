package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.payload.request.ProductRequest;
import com.chathra.fernanPharmacyBackend.payload.response.ProductResponse;
import com.chathra.fernanPharmacyBackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:34 pm
 */
@RestController
@RequestMapping("api/product")
public class ProductApi {

    @Autowired
    ProductService productService;


    @PostMapping()
    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest){

        ProductResponse productResponse = productService.saveProduct(productRequest);

        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);

    }

}

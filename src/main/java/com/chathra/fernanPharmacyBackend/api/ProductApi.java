package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Product;
import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.ProductRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataResponse;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.ProductResponse;
import com.chathra.fernanPharmacyBackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/save")
    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest){

        ProductResponse productResponse = productService.saveProduct(productRequest);

        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);

    }

    @PostMapping()
    public DataTableResponse<Product> getProdctsForDatatable(@RequestBody DataTableRequest dataTableRequest) {

        System.out.println("value - ");

        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

//        return userService.getUsers(dataTableRequest);
        return productService.getProductsForDataTable(dataTableRequest);

//        return null;
    }


    @GetMapping()
    public ResponseEntity<DataResponse> getActiveProducts() {

        System.out.println("value - ");


//        return userService.getUsers(dataTableRequest);

        DataResponse<Product> dataResponse = new DataResponse<>(200, productService.getActiveProducts());

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);

//        return null;
    }


    @PostMapping("/remove/{id}")
    public ResponseEntity<Boolean> removeProduct(@PathVariable Long id) {

        System.out.println(id);

        Boolean aBoolean = productService.removeProduct(id);
        return new ResponseEntity<>(aBoolean, HttpStatus.CREATED);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Orders;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.OrderRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.OrderResponse;
import com.chathra.fernanPharmacyBackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author abhis
 */
@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public DataTableResponse<Orders> getOrdersForDatatable(@RequestBody DataTableRequest dataTableRequest) {


        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

        return orderService.getOrdersForDataTable(dataTableRequest);

    }


    @PostMapping("/add-order")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest.toString());

        OrderResponse orderResponse = orderService.addOrder(orderRequest);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

}

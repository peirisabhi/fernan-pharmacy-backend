/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Orders;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DataTableResponse<Orders> getPatientsForDatatable(@RequestBody DataTableRequest dataTableRequest) {


        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

        return orderService.getOrdersForDataTable(dataTableRequest);

    }
}

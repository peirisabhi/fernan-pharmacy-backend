package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Orders;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/12/2021
 * Time: 11:26 pm
 */
@Service
public class OrderService {

    @Autowired
    OrdersRepository orderRepository;





    public DataTableResponse<Orders> getOrdersForDataTable(DataTableRequest dataTableRequest){

        DataTableResponse<Orders> orderDataTableResponse = new DataTableResponse<>();

        List<Orders> orderList = orderRepository.getOrdersForDataTable(dataTableRequest.getSearch().getValue());
//        List<Product> productList = productRepository.findAll();

        System.out.println("orderList.size() -- " + orderList.size());

        orderDataTableResponse.setData(orderList);
        orderDataTableResponse.setDraw(dataTableRequest.getDraw());
        orderDataTableResponse.setRecordsTotal(orderList.size());
        orderDataTableResponse.setRecordsFiltered(orderList.size());


        return orderDataTableResponse;
    }

}

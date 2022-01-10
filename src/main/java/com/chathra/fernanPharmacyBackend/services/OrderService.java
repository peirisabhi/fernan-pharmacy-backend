package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.*;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.OrderItemRequest;
import com.chathra.fernanPharmacyBackend.payload.request.OrderRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.OrderItemResponse;
import com.chathra.fernanPharmacyBackend.payload.response.OrderResponse;
import com.chathra.fernanPharmacyBackend.repositories.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;


    public OrderResponse addOrder(OrderRequest orderRequest) {

        OrderResponse orderResponse = new OrderResponse();
        List<OrderItemResponse> orderItemResponseList = new ArrayList<>();

        Orders orders = new Orders();
        BeanUtils.copyProperties(orderRequest, orders);

        orders.setCreateDate(new Date());
        orders.setStatus("Pending");

        if(orderRequest.getPatientId() != null){
            Patient patient = patientRepository.findById(orderRequest.getPatientId()).get();
            orders.setPatient(patient);
        }
        if(orderRequest.getDoctorId() != null){
            Doctor doctor = doctorRepository.findById(orderRequest.getDoctorId()).get();
            orders.setDoctor(doctor);
        }

        Orders savedOrder = orderRepository.save(orders);

        for (OrderItemRequest orderItemRequest : orderRequest.getOrderItems()) {
            Product product = productRepository.findById(orderItemRequest.getProductId())
                    .orElse(null);

            if (product != null) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setPrice(product.getSellingPrice());
                orderItem.setQty(orderItemRequest.getQty());
                orderItem.setOrders(savedOrder);

                OrderItem savedOrderItem = orderItemRepository.save(orderItem);

                OrderItemResponse orderItemResponse = new OrderItemResponse();
                orderItemResponse.setPrice(savedOrderItem.getPrice());
                orderItemResponse.setQty(savedOrderItem.getQty());
                orderItemResponse.setTotal(savedOrderItem.getPrice() * savedOrderItem.getQty());
                orderItemResponse.setProduct(product.getName());

                orderItemResponseList.add(orderItemResponse);
            }

        }

        BeanUtils.copyProperties(orderResponse, orderRequest);
        orderResponse.setId(savedOrder.getId());

        orderResponse.setOrderItems(orderItemResponseList);


        return orderResponse;

    }


    public DataTableResponse<Orders> getOrdersForDataTable(DataTableRequest dataTableRequest) {

        DataTableResponse<Orders> orderDataTableResponse = new DataTableResponse<>();

        List<Orders> orderList = orderRepository.getOrdersForDataTable(dataTableRequest.getSearch().getValue());
//        List<Product> productList = productRepository.findAll();

        System.out.println("orderList.size() -- " + orderList.size());

        System.out.println(orderList.toString());

        orderDataTableResponse.setData(orderList);
        orderDataTableResponse.setDraw(dataTableRequest.getDraw());
        orderDataTableResponse.setRecordsTotal(orderList.size());
        orderDataTableResponse.setRecordsFiltered(orderList.size());


        return orderDataTableResponse;
    }

}

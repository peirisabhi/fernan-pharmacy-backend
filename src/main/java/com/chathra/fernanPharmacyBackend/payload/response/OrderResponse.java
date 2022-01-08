package com.chathra.fernanPharmacyBackend.payload.response;

import com.chathra.fernanPharmacyBackend.payload.request.OrderItemRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 6:31 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    Long id;

    String fname;

    String lname;

    String address;

    String phone;

    String email;

    String note;

    double total;

    double subTotal;

    double shipping;

    List<OrderItemResponse> orderItems;
}

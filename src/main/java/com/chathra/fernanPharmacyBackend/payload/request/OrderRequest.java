package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 02/01/2022
 * Time: 9:14 am
 */
@Data
@ToString
@Serialization
public class OrderRequest {

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

    List<OrderItemRequest> orderItems;
}

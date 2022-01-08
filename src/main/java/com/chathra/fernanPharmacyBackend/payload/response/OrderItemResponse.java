package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 02/01/2022
 * Time: 9:19 am
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {


    Integer qty;

    String product;

    double price;

    double total;

}

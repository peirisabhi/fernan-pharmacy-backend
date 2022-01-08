package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 02/01/2022
 * Time: 9:19 am
 */
@Data
@ToString
@Serialization
public class OrderItemRequest {

    Long productId;

    Integer qty;

}

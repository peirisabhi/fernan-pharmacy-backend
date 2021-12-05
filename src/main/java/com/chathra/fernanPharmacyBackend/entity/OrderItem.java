package com.chathra.fernanPharmacyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/12/2021
 * Time: 8:06 pm
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Serialization
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Orders orders;

    double price;

    int qty;


}

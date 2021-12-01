package com.chathra.fernanPharmacyBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer qty;

    private Double discount;

    private String description;

    private Double buyingPrice;

    private Double sellingPrice;

    @Temporal(TemporalType.DATE)
    private Date mfd;

    @Temporal(TemporalType.DATE)
    private Date exp;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;


}

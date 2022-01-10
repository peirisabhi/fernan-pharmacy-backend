package com.chathra.fernanPharmacyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/12/2021
 * Time: 7:57 pm
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Serialization
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String fname;

    String lname;

    String address;

    String phone;

    String email;

    String note;

    double total;

    double subTotal;

    double shipping;

    @Temporal(TemporalType.DATE)
    Date createDate;

    String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

}

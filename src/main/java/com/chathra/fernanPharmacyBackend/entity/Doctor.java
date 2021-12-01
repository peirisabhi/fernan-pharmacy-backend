package com.chathra.fernanPharmacyBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;

    private String lname;

    private String mobile;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String about;

    private Double price;

    private String img;

    @Temporal(TemporalType.DATE)
    private Date registerdAt;

    private Integer status;

    private String shortDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialities_id")
    private Specialities specialities;

    private String password;

    private String email;


}

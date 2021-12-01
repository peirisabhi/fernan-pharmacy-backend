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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private Date dob;

    private String bloodGroup;

    private String email;

    private String mobile;

    private String address;

    private String img;

    private String password;

    private Integer status;

    private String verificationCode;

    @Temporal(TemporalType.DATE)
    private Date registerAt;


}

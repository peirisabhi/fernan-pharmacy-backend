package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 13/01/2022
 * Time: 10:36 am
 */
@Data
@ToString
@Serialization
public class UpdatePatientRequest {

    private Long id;

    private String fullName;

//    private Date dob;

    private String bloodGroup;

//    private String email;

    private String mobile;

    private String address;

//    private String img;


}

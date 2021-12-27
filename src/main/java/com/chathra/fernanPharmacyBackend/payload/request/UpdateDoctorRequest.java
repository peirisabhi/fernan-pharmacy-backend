package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 26/12/2021
 * Time: 8:20 pm
 */
@Data
@ToString
@Serialization
public class UpdateDoctorRequest {

    Long id;

    String name;

    String mobile;

    String gender;

    String nic;

    Date dob;

    String about;

    double price;
}

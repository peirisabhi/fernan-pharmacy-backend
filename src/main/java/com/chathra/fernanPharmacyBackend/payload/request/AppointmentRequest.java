package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 31/12/2021
 * Time: 8:59 pm
 */
@Data
@ToString
@Serialization
public class AppointmentRequest {

    Long id;

    Date date;

    Date time;

    Long doctorId;

    Integer patientId;



}

package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 6:31 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponse {

    Long id;

    Date date;

    Date time;

    String doctor;

    String patient;

    String specialities;

    String status;

    String payment;


}

package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.payload.request.AppointmentRequest;
import com.chathra.fernanPharmacyBackend.payload.response.AppointmentResponse;
import com.chathra.fernanPharmacyBackend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 31/12/2021
 * Time: 8:58 pm
 */
@RestController
@RequestMapping("/api/appointment")
public class AppointmentApi {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping()
    public ResponseEntity<AppointmentResponse> addAppointment(@RequestBody AppointmentRequest appointmentRequest){
        System.out.println(appointmentRequest.toString());
        AppointmentResponse appointmentResponse = appointmentService.addAppointment(appointmentRequest);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.CREATED);
    }

}

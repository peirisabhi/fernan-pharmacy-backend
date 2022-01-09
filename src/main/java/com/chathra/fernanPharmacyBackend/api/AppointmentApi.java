package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.payload.request.AppointmentRequest;
import com.chathra.fernanPharmacyBackend.payload.response.AppointmentResponse;
import com.chathra.fernanPharmacyBackend.payload.response.DataResponse;
import com.chathra.fernanPharmacyBackend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("patient/{id}")
    public ResponseEntity<DataResponse> getAppointmentsByPatient(@PathVariable Long id){
        System.out.println(id);

        DataResponse<AppointmentResponse> dataResponse = new DataResponse<>(200, appointmentService.getAppointmetsByPatient(id));

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }



    @GetMapping("doctor/{id}")
    public ResponseEntity<DataResponse> getAppointmentsByDoctor(@PathVariable Long id){
        System.out.println(id);

        DataResponse<AppointmentResponse> dataResponse = new DataResponse<>(200, appointmentService.getAppointmetsByDoctor(id));

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

}

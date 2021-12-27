/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Product;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.UpdateDoctorRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataResponse;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abhis
 */
@RestController
@RequestMapping("/api/doctor")
public class DoctorApi {

    @Autowired
    DoctorService doctorService;

//    @GetMapping()
//    public List<Doctor> list() {
//        return doctorService.getAllDoctors();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Long id) {
        System.out.println("id --- " + id);
        Doctor doctor = doctorService.getDoctorById(id);

        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

//    @PutMapping()
//    public ResponseEntity<Doctor> put(@RequestBody Doctor doctor) {
//
//        doctor = doctorService.updateDoctor(doctor);
//
//        return new ResponseEntity<>(doctor, HttpStatus.OK);
//    }
    
    @PostMapping("/save")
    public Doctor post(@RequestBody Doctor input) {

        System.out.println("input--"  + input.toString());

        input.setRegisterdAt(new Timestamp(new Date().getTime()));
        input.setAbout("");
        input.setDob(new Timestamp(new Date().getTime()));
        input.setGender("Fe-Male");
        input.setImg("");
        input.setMobile("");
        input.setPrice((double) 0);
        return doctorService.addDoctor(input);
    }


    @PostMapping("/update")
    public Doctor update(@RequestBody UpdateDoctorRequest updateDoctorRequest) {

        System.out.println("------------------ " + updateDoctorRequest.toString());

        return doctorService.updateDoctor(updateDoctorRequest);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }


    @PostMapping()
    public DataTableResponse<Doctor> getDoctorsForDatatable(@RequestBody DataTableRequest dataTableRequest) {


        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

        return doctorService.getDoctorsForDataTable(dataTableRequest);

    }

    @GetMapping()
    public ResponseEntity<DataResponse> getActiveDoctors() {

        System.out.println("value - ");


        DataResponse<Doctor> dataResponse = new DataResponse<>(200, doctorService.getActiveDoctirs());

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Product;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author abhis
 */
@RestController
@RequestMapping("/api/doctor")
public class DoctorApi {

    @Autowired
    DoctorService doctorService;

    @GetMapping()
    public List<Doctor> list() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
    
    @PostMapping("/save")
    public Doctor post(@RequestBody Doctor input) {
        input.setRegisterdAt(new Timestamp(new Date().getTime()));
        return doctorService.addDoctor(input);
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
}

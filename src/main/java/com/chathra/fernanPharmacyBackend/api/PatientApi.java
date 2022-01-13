/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.UpdateDoctorRequest;
import com.chathra.fernanPharmacyBackend.payload.request.UpdatePatientRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.repositories.PatientRepository;
import com.chathra.fernanPharmacyBackend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author abhis
 */
@RestController
@RequestMapping("/api/patient")
public class PatientApi {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

//    @GetMapping()
//    public List<Patient> list() {
//        return patientService.getAllDoctors();
//    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id) {
        System.out.println("id --- " + id);
        return new ResponseEntity<>(patientRepository.findById(id).orElse(null), HttpStatus.OK);
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
    
    @PostMapping("/save")
    public Patient post(@RequestBody Patient input) {
//        input.setRegisteredAt(new Timestamp(new Date().getTime()));
        return patientService.addPatient(input);
    }
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }
//


    @PostMapping("/update")
    public Patient update(@RequestBody UpdatePatientRequest updatePatientRequest) {

        System.out.println("------------------ " + updatePatientRequest.toString());

        return patientService.updatePatient(updatePatientRequest);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }


    @PostMapping()
    public DataTableResponse<Patient> getPatientsForDatatable(@RequestBody DataTableRequest dataTableRequest) {


        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

        return patientService.getPatientsForDataTable(dataTableRequest);

    }
}

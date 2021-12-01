/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Specialities;
import com.chathra.fernanPharmacyBackend.services.SpecialitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author abhis
 */
@RestController
@RequestMapping("/api/specialities")
public class SpecialitiesApi {

    @Autowired
    SpecialitiesService specialitiesService;

    @GetMapping()
    public List<Specialities> list() {
        return specialitiesService.getAllSpecialities();
    }
    
//    @GetMapping("/{id}")
//    public Object get(@PathVariable String id) {
//        return null;
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
//
    @PostMapping
    public Specialities post(@RequestBody Specialities input) {
        input.setCreatedAt(new Timestamp(new Date().getTime()));
        return specialitiesService.addSpecialities(input);
    }
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }
//
}

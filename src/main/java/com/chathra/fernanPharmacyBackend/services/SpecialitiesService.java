package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Specialities;
import com.chathra.fernanPharmacyBackend.repositories.SpecialitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialitiesService {

    @Autowired
    SpecialitiesRepository specialitiesRepository;

    public List<Specialities> getAllSpecialities() {
        return specialitiesRepository.findAll();
    }

    public Specialities getSpecialitiesById(int id) {
        return specialitiesRepository.findById((long) id).orElse(null);
    }

    public Specialities addSpecialities(Specialities specialities) {
        return specialitiesRepository.save(specialities);
    }

//    public Doctor updateProd(Doctor doctor) {
//        Doctor doctorUpdate = doctorRepository.findById(doctor.getId()).orElse(null);
//        if (doctorUpdate != null) {
//            doctorUpdate.setAbout(doctor.getAbout());
//            doctorUpdate.setDob(doctor.getDob());
//            doctorUpdate.setFname(doctor.getFname());
//            doctorUpdate.setGender(doctor.getGender());
//            doctorUpdate.setLname(doctor.getLname());
//            doctorUpdate.setImg(doctor.getImg());
//            doctorUpdate.setMobile(doctor.getMobile());
//            doctorUpdate.setShortDescription(doctor.getShortDescription());
//
//        }
//        return doctorUpdate;
//    }
}

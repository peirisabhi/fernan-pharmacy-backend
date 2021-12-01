package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
//
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


    public List<Doctor> doctorLogin(String email){
        return doctorRepository.getDoctorByEmail(email);
    }

}

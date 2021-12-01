package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import com.chathra.fernanPharmacyBackend.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllDoctors() {
        return patientRepository.findAll();
    }

    public Patient getDoctorById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient addDoctor(Patient patient) {
        return patientRepository.save(patient);
    }


    public List<Patient> patientLogin(String email){
        return patientRepository.getPatientByEmail(email);
    }
}

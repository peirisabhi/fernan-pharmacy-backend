package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
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


    public DataTableResponse<Patient> getPatientsForDataTable(DataTableRequest dataTableRequest){

        DataTableResponse<Patient> patientDataTableResponse = new DataTableResponse<>();

        List<Patient> patientList = patientRepository.getPatientsForDataTable(dataTableRequest.getSearch().getValue());

        System.out.println("patientList.size() -- " + patientList.size());

        patientDataTableResponse.setData(patientList);
        patientDataTableResponse.setDraw(dataTableRequest.getDraw());
        patientDataTableResponse.setRecordsTotal(patientList.size());
        patientDataTableResponse.setRecordsFiltered(patientList.size());


        return patientDataTableResponse;
    }

}

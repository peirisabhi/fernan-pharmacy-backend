package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import com.chathra.fernanPharmacyBackend.model.Login;
import com.chathra.fernanPharmacyBackend.services.DoctorService;
import com.chathra.fernanPharmacyBackend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginApi {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @PostMapping
    public HashMap<String, Object> post(@RequestBody Login login) {

        HashMap<String, Object> response = new HashMap<>();

        System.out.println(login);

        if(login != null) {
            List<Doctor> doctorList = doctorService.doctorLogin(login.getEmail());
            List<Patient> patientList = patientService.patientLogin(login.getEmail());

            if(doctorList.size() != 0){
                if(doctorList.iterator().hasNext()){
                    Doctor doctor = doctorList.iterator().next();

                    if(doctor.getPassword().equals(login.getPassword())){
                        if(doctor.getStatus() == 1){
                            response.put("status", 200);
                            response.put("id", doctor.getId());
                            response.put("type", "DOCTOR");
                        }else{
                            response.put("status", 500);
                            response.put("message", "Your are not active user");
                        }
                    }else{
                        response.put("status", 500);
                        response.put("message", "Invalid Password");
                    }
                }
            }else if(patientList.size() != 0){
                if(patientList.iterator().hasNext()){
                    Patient patient = patientList.iterator().next();

                    if(patient.getPassword().equals(login.getPassword())){
                        if(patient.getStatus() == 1){
                            response.put("status", 200);
                            response.put("id", patient.getId());
                            response.put("type", "PATIENT");
                        }else{
                            response.put("status", 500);
                            response.put("message", "Your are not active user");
                        }
                    }else{
                        response.put("status", 500);
                        response.put("message", "Invalid Password");
                    }
                }
            }else{
                response.put("status", 500);
                response.put("message", "Invalid Email");
            }


        }else{
            response.put("status", 500);
            response.put("message", "Empty");
        }

        return response;
    }

}

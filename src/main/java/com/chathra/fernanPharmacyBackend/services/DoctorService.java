package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Specialities;
import com.chathra.fernanPharmacyBackend.exceptions.DuplicateDataFoundException;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.UpdateDoctorRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.repositories.DoctorRepository;
import com.chathra.fernanPharmacyBackend.repositories.SpecialitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.chathra.fernanPharmacyBackend.config.ComPath.UPLOAD_URL;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    SpecialitiesRepository specialitiesRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor addDoctor(Doctor doctor) {
        try {
            Specialities specialities = specialitiesRepository.getById(1L);

            doctor.setSpecialities(specialities);
            doctor = doctorRepository.save(doctor);
        }catch (Exception e){
            e.printStackTrace();
            throw new DuplicateDataFoundException("Duplicate data found", doctor.getEmail());
        }

        return doctor;
    }


    public Doctor updateDoctor(UpdateDoctorRequest updateDoctorRequest) {
        System.out.println("updateDoctor");
        Doctor currentDoctor;

        try {

            currentDoctor = doctorRepository.findById(updateDoctorRequest.getId()).get();
            System.out.println("currentDoctor -- " + currentDoctor.toString());
            currentDoctor.setFname(updateDoctorRequest.getName());
            currentDoctor.setMobile(updateDoctorRequest.getMobile());
            currentDoctor.setGender(updateDoctorRequest.getGender());
            currentDoctor.setDob(updateDoctorRequest.getDob());
//            currentDoctor.setSpecialities();
            currentDoctor.setAbout(updateDoctorRequest.getAbout());
            currentDoctor.setPrice(updateDoctorRequest.getPrice());

            currentDoctor = doctorRepository.save(currentDoctor);

            System.out.println("currentDoctor -- " + currentDoctor.toString());
        }catch (Exception e){
            e.printStackTrace();
            throw new DuplicateDataFoundException("Something Went Wrong", " ");
        }

        return currentDoctor;
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


    public DataTableResponse<Doctor> getDoctorsForDataTable(DataTableRequest dataTableRequest){

        DataTableResponse<Doctor> doctorDataTableResponse = new DataTableResponse<>();

        List<Doctor> doctorList = doctorRepository.getDoctorsForDataTable(dataTableRequest.getSearch().getValue());

        System.out.println("doctorList.size() -- " + doctorList.size());

        doctorDataTableResponse.setData(doctorList);
        doctorDataTableResponse.setDraw(dataTableRequest.getDraw());
        doctorDataTableResponse.setRecordsTotal(doctorList.size());
        doctorDataTableResponse.setRecordsFiltered(doctorList.size());


        return doctorDataTableResponse;
    }

    public List<Doctor> getActiveDoctirs(){
        List<Doctor> doctorList = doctorRepository.findAllByStatus(1);

        for(Doctor doctor : doctorList){
            System.out.println(doctor.getImg().equals(""));
            if(!doctor.getImg().equals("")){
                doctor.setImg(UPLOAD_URL + "images\\doctor_images\\" +doctor.getImg());
            }else {
                doctor.setImg(" ");
            }
        }
        return doctorList;
    }

}

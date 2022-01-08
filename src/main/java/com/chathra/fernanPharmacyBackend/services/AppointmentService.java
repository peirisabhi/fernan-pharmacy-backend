package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Appointment;
import com.chathra.fernanPharmacyBackend.entity.Category;
import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import com.chathra.fernanPharmacyBackend.exceptions.BadRequestException;
import com.chathra.fernanPharmacyBackend.payload.request.AppointmentRequest;
import com.chathra.fernanPharmacyBackend.payload.response.AppointmentResponse;
import com.chathra.fernanPharmacyBackend.repositories.AppointmentRepository;
import com.chathra.fernanPharmacyBackend.repositories.DoctorRepository;
import com.chathra.fernanPharmacyBackend.repositories.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 01/01/2022
 * Time: 8:58 pm
 */
@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;


    @SneakyThrows
    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest){

        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Patient"));


        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Doctor"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setCreatedAt(new Date());
        appointment.setPatient(patient);
        appointment.setStatus(1);
        appointment.setDate(dateFormat.parse(appointmentRequest.getDate()));
        appointment.setTime(timeFormat.parse(appointmentRequest.getTime()));
        appointment.setAbout(appointmentRequest.getAbout());
        appointment.setMobile(appointmentRequest.getMobile());
        appointment.setName(appointmentRequest.getName());
        appointment.setNic(appointmentRequest.getNic());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setSpecialities(doctor.getSpecialities().getSpecialities());
        appointmentResponse.setDate(appointment.getDate());
        appointmentResponse.setTime(appointment.getTime());
        appointmentResponse.setId(savedAppointment.getId());

        return appointmentResponse;

    }


    public List<AppointmentResponse> getAppointmetsByPatient(Long patientId){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Patient"));

        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByPatient(patient);

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();

        for (Appointment appointment : appointmentList){
            AppointmentResponse appointmentResponse = new AppointmentResponse();

            appointmentResponse.setId(appointment.getId());
            appointmentResponse.setTime(appointment.getTime());
            appointmentResponse.setDate(appointment.getDate());
            appointmentResponse.setSpecialities(appointment.getDoctor().getSpecialities().getSpecialities());
            appointmentResponse.setDoctor(appointment.getDoctor().getFname() + appointment.getDoctor().getLname());

            String status = "";
            if (appointment.getStatus() == 1){
                status = "Pending";
            }else if (appointment.getStatus() == 2){
                status = "Approved";
            }else if (appointment.getStatus() == 3){
                status = "Canceled";
            }
            appointmentResponse.setStatus(status);
            appointmentResponse.setPayment("Not Paid");

            appointmentResponseList.add(appointmentResponse);
        }

        return appointmentResponseList;
    }

}

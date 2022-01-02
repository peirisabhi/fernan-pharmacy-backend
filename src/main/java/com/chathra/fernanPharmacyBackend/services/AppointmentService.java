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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

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


    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest){

        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Patient"));


        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Doctor"));


        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setCreatedAt(new Date());
        appointment.setPatient(patient);
        appointment.setStatus(1);
        appointment.setDate(appointmentRequest.getDate());
        appointment.setTime(appointmentRequest.getTime());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setSpecialities(doctor.getSpecialities().getSpecialities());
        appointmentResponse.setDate(appointment.getDate());
        appointmentResponse.setTime(appointment.getTime());
        appointmentResponse.setId(savedAppointment.getId());

        return appointmentResponse;

    }

}

package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Appointment;
import com.chathra.fernanPharmacyBackend.entity.Doctor;
import com.chathra.fernanPharmacyBackend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 01/01/2022
 * Time: 8:59 pm
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> getAppointmentsByPatient(Patient patient);

    List<Appointment> getAppointmentsByDoctor(Doctor doctor);

}

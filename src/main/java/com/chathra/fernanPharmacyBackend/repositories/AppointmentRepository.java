package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 01/01/2022
 * Time: 8:59 pm
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

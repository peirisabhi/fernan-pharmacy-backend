package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> getPatientByEmail(String email);

    @Query("SELECT p FROM Patient p WHERE p.status = 1 AND ( p.fullName LIKE :value% OR p.bloodGroup LIKE :value% OR p.dob LIKE :value% OR p.email LIKE :value% OR p.mobile LIKE :value%) ")
    List<Patient> getPatientsForDataTable(@Param("value") Object value);
}

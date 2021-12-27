package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

//    @Query("SELECT d FROM Doctor d WHERE d.email = ?1")
    List<Doctor> getDoctorByEmail(String email);


    @Query("SELECT d FROM Doctor d WHERE d.status = 1 AND ( d.lname LIKE :value% OR d.fname LIKE :value% OR d.mobile LIKE :value% OR d.gender LIKE :value% OR d.email LIKE :value% OR d.specialities.specialities LIKE :value%) ")
    List<Doctor> getDoctorsForDataTable(@Param("value") Object value);


    List<Doctor> findAllByStatus(Integer status);


}

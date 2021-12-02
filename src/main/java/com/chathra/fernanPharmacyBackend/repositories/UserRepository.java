package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.User;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 8:11 am
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findUserByEmail(String email);

    public User findByActiveStatus(Boolean status);

//    @Query("SELECT u FROM User u WHERE  u.fname LIKE :value%")
    @Query("SELECT u FROM User u WHERE  u.activeStatus = 1 AND (u.fname LIKE :value% OR u.lname LIKE :value% OR u.email LIKE :value% OR u.gender LIKE :value% OR u.mobile LIKE :value% OR u.userRole.role LIKE :value%)")
//    public List<User> getUsersForDataTable();
    public List<User> getUsersForDataTable(@Param("value") String value);

}

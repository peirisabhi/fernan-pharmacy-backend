package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/12/2021
 * Time: 7:53 pm
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o WHERE o.fname LIKE :value% OR o.lname LIKE :value% OR o.email LIKE :value% OR o.address LIKE :value% OR o.phone LIKE :value% OR o.total LIKE :value% OR o.subTotal LIKE :value% OR o.createDate LIKE :value%")
    List<Orders> getOrdersForDataTable(@Param("value") Object value);

}

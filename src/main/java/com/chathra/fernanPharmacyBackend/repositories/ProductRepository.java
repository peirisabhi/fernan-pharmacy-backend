package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:35 pm
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT u FROM Product u WHERE  u.status = 1 AND (u.name LIKE :value% OR u.brand.brand LIKE :value% OR u.category.category LIKE :value% OR u.qty LIKE :value%)")
    List<Product> getProductsForDataTable(@Param("value") Object value);


    List<Product> findAllByStatus(Integer status);

}

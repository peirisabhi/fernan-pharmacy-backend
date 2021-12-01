package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:35 pm
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}

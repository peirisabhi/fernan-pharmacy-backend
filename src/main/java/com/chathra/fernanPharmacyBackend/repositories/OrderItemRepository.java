package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 03/01/2022
 * Time: 5:57 pm
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

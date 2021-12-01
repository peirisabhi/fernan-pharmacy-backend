package com.chathra.fernanPharmacyBackend.repositories;

import com.chathra.fernanPharmacyBackend.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 8:34 am
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}

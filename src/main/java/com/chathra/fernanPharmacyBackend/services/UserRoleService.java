package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.UserRole;
import com.chathra.fernanPharmacyBackend.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 10/11/2021
 * Time: 7:34 am
 */
@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles(){
       return userRoleRepository.findAll();
    }

}

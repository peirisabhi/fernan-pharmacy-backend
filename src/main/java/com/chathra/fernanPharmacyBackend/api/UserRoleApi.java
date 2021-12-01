package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.UserRole;
import com.chathra.fernanPharmacyBackend.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 10/11/2021
 * Time: 7:34 am
 */
@RestController
@RequestMapping("/api/user-role")
public class UserRoleApi {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping()
    public List<UserRole> getUserRoles(){
        return userRoleService.getAllUserRoles();
    }

}

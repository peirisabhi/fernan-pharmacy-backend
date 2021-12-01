package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.payload.request.SaveUserRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.SaveUserResponse;
import com.chathra.fernanPharmacyBackend.repositories.UserRepository;
import com.chathra.fernanPharmacyBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 8:10 am
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<SaveUserResponse> addUser(SaveUserRequest saveUserRequest) {

        System.out.println("user request - " + saveUserRequest.toString());

        SaveUserResponse saveUserResponse = userService.saveUser(saveUserRequest);
        return new ResponseEntity<>(saveUserResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public DataTableResponse User() {

//        System.out.println("value - " + value);

        return userService.getAllUsers();
    }


}

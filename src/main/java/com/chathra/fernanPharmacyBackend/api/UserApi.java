package com.chathra.fernanPharmacyBackend.api;

import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.payload.request.DataTableRequest;
import com.chathra.fernanPharmacyBackend.payload.request.Page;
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

    @PostMapping("/save")
    public ResponseEntity<SaveUserResponse> addUser(SaveUserRequest saveUserRequest) {

        System.out.println("user request - " + saveUserRequest.toString());

        SaveUserResponse saveUserResponse = userService.saveUser(saveUserRequest);
        return new ResponseEntity<>(saveUserResponse, HttpStatus.CREATED);
    }


    @PostMapping("/remove/{id}")
    public ResponseEntity<Boolean> removeUser(@PathVariable Long id) {

        System.out.println(id);

        Boolean removeUser = userService.removeUser(id);
        return new ResponseEntity<>(removeUser, HttpStatus.CREATED);
    }

    @PostMapping
    public DataTableResponse<User> User(@RequestBody  DataTableRequest dataTableRequest) {

        System.out.println("value - ");

        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

//        return userService.getUsers(dataTableRequest);
        return userService.getUsersForDataTable(dataTableRequest);
    }


}

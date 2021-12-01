package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.entity.UserRole;
import com.chathra.fernanPharmacyBackend.exceptions.BadRequestException;
import com.chathra.fernanPharmacyBackend.payload.request.SaveUserRequest;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.SaveUserResponse;
import com.chathra.fernanPharmacyBackend.repositories.UserRepository;
import com.chathra.fernanPharmacyBackend.repositories.UserRoleRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.chathra.fernanPharmacyBackend.config.ComPath.UPLOAD_URL;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 8:29 am
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

//    public List<User> getUsersByEmail(String email){
//       return userRepository.getUserByEmail(email);
//    }

    public SaveUserResponse saveUser(SaveUserRequest saveUserRequest) {

        User userByEmail = userRepository.findUserByEmail(saveUserRequest.getEmail());

        UserRole userRole = userRoleRepository.findById(saveUserRequest.getUserRole())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid User Role"));

        if (userByEmail != null) {
            System.out.println("This email already exists");
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "This email already exists");
        }

        String profileImage = new Date().getTime() + "_" + UUID.randomUUID().toString().concat(".").concat(FilenameUtils.getExtension(saveUserRequest.getImg().getOriginalFilename()));

        Path profileImagePath = Paths.get(UPLOAD_URL + "images\\user_images\\", profileImage);

        try {
            Files.write(profileImagePath, saveUserRequest.getImg().getBytes());
            System.out.println("image saved --- ");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Image upload fail");
        }

        User user = new User();
        user.setFname(saveUserRequest.getFname());
        user.setLname(saveUserRequest.getLname());
        user.setMobile(saveUserRequest.getMobile());
        user.setEmail(saveUserRequest.getEmail());
        user.setGender(saveUserRequest.getGender());
        user.setDob(saveUserRequest.getDob());
        user.setAddress(saveUserRequest.getAddress());
        user.setPassword(saveUserRequest.getPassword());
        user.setRegisteredDate(new Date());
        user.setUserRole(userRole);
        user.setActiveStatus(true);
        user.setBlockStatus(false);
        user.setImg(profileImage);

        User savedUser = userRepository.save(user);

        SaveUserResponse saveUserResponse = new SaveUserResponse();
        saveUserResponse.setId(savedUser.getId());
        saveUserResponse.setFname(savedUser.getFname());
        saveUserResponse.setLname(savedUser.getLname());
        saveUserResponse.setMobile(savedUser.getMobile());
        saveUserResponse.setEmail(savedUser.getEmail());
        saveUserResponse.setGender(savedUser.getGender());
        saveUserResponse.setAddress(savedUser.getAddress());
        saveUserResponse.setUserRole(savedUser.getUserRole().getRole());
        saveUserResponse.setImgUrl(profileImagePath.toString());


        return saveUserResponse;
    }


    public DataTableResponse getAllUsers() {

        DataTableResponse<User> userDataTableResponse = new DataTableResponse<>();

        List<User> userList = userRepository.getUsersForDataTable();
        userDataTableResponse.setData(userList);
        userDataTableResponse.setDraw(1);
        userDataTableResponse.setRecordsTotal(userList.size());
        userDataTableResponse.setRecordsFiltered(userList.size());

        return userDataTableResponse;
    }

}

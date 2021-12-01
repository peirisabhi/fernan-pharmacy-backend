package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 7:07 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserResponse {

    private Long id;

    private String fname;

    private String lname;

    private String mobile;

    private String email;

    private String gender;

    private Date dob;

    private String address;

    private String userRole;

    private String imgUrl;

}

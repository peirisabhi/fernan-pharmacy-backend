package com.chathra.fernanPharmacyBackend.payload.request;

import com.chathra.fernanPharmacyBackend.entity.UserRole;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 6:55 pm
 */
@Data
@ToString
@Serialization
public class SaveUserRequest {

    private String fname;

    private String lname;

    private String mobile;

    private String email;

    private String gender;

    private Date dob;

    private String address;

    private String password;

    private Long userRole;

    private MultipartFile img;

}

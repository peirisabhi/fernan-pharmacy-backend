package com.chathra.fernanPharmacyBackend.payload.request;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:37 pm
 */
@Data
@ToString
@Serialization
public class ProductRequest {

    Long id;

    String name;

    Long category;

    Long brand;

    int qty;

    double price;

    Date mfd;

    Date exp;

    String desc;

    private MultipartFile img;

}

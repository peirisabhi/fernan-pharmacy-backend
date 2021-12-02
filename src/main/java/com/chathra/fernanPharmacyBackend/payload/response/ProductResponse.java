package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 6:31 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    Long id;

    String name;

    String category;

    String brand;

    Long qty;

    double price;

    String mfd;

    String exp;

    String desc;

    String imgUrl;
}

package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 19/12/2021
 * Time: 6:48 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataResponse<T> {

    int status;

    List<T> data;

}

package com.chathra.fernanPharmacyBackend.payload.response;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 7:07 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataTableResponse<T> {

    private List<T> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;

}

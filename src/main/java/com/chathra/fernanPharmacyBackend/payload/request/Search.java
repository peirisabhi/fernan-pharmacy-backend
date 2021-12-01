package com.chathra.fernanPharmacyBackend.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 21/11/2021
 * Time: 2:16 pm
 */
@Setter
@Getter
@NoArgsConstructor
public class Search {
    private String value;
    private String regexp;
}

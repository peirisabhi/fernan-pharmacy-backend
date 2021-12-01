package com.chathra.fernanPharmacyBackend.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 21/11/2021
 * Time: 2:17 pm
 */
@Setter
@Getter
@NoArgsConstructor
public class Column {
    private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;
    private Search search;

    public Column(String data) {
        this.data = data;
    }
}

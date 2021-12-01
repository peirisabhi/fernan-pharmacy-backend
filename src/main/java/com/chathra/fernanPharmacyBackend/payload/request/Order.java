package com.chathra.fernanPharmacyBackend.payload.request;

import com.chathra.fernanPharmacyBackend.payload.enums.Direction;
import lombok.*;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 21/11/2021
 * Time: 2:18 pm
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private Integer column;
    private Direction dir;
}

package com.chathra.fernanPharmacyBackend.comparators;

import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.payload.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 02/12/2021
 * Time: 8:53 am
 */


@AllArgsConstructor
public class UserComparators {

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<Key, Comparator<User>> map = new HashMap<>();

    static {
        map.put(new Key("fname", Direction.asc), Comparator.comparing(User::getFname));
        map.put(new Key("fname", Direction.desc), Comparator.comparing(User::getFname)
                .reversed());

        map.put(new Key("lname", Direction.asc), Comparator.comparing(User::getLname));
        map.put(new Key("lname", Direction.desc), Comparator.comparing(User::getLname)
                .reversed());

        map.put(new Key("email", Direction.asc), Comparator.comparing(User::getEmail));
        map.put(new Key("email", Direction.desc), Comparator.comparing(User::getEmail)
                .reversed());

    }

    public static Comparator<User> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }


}

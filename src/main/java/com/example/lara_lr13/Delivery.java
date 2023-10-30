package com.example.lara_lr13;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Delivery {
    int id;
    String streetName;
    int houseNumber;

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}

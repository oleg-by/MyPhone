package main.java.com.solvd.laba.interfaces;

import main.java.com.solvd.laba.exceptions.ChargingException;

public interface Chargerable {
    float COEFFICIENT = (float) 1.4;
    void charge (int chargingCurrent) throws ChargingException;
}

package main.java.interfaces;

import main.java.exceptions.ChargingException;

public interface Chargerable {
    float COEFFICIENT = (float) 1.4;
    void charge (int chargingCurrent) throws ChargingException;
}

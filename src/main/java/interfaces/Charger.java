package main.java.interfaces;

import main.java.ChargingException;

public interface Charger {
    float COEFFICIENT = (float) 1.4;
    void charge (int chargingCurrent) throws ChargingException;
}

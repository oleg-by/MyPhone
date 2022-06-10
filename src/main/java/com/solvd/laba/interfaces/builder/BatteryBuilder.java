package com.solvd.laba.interfaces.builder;

import com.solvd.laba.model.Battery;

public interface BatteryBuilder {
    BatteryBuilder setCapacity(int capacity);
    BatteryBuilder setTypeBattery(String type);
    Battery build();
}

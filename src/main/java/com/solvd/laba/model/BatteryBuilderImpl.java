package com.solvd.laba.model;

import com.solvd.laba.exceptions.BatteryException;
import com.solvd.laba.interfaces.builder.BatteryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BatteryBuilderImpl implements BatteryBuilder {

    private static final Logger LOGGER = LogManager.getLogger(BatteryBuilderImpl.class);

    Battery battery = new Battery();

    @Override
    public BatteryBuilder setCapacity(int capacity) {
        try {
            battery.setCapacity(capacity);
        } catch (BatteryException e) {
            LOGGER.error(e.getMessage());
        }
        return this;
    }

    @Override
    public BatteryBuilder setTypeBattery(String type) {
        battery.setTypeBattery(type);
        return this;
    }

    @Override
    public Battery build() {
        return battery;
    }
}

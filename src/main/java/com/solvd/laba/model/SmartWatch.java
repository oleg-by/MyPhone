package com.solvd.laba.model;

import com.solvd.laba.enums.Color;
import com.solvd.laba.enums.GadgetName;
import com.solvd.laba.enums.GadgetType;

public class SmartWatch extends Gadget {
    private float displaySize;

    public SmartWatch() {
    }

    public SmartWatch(GadgetName gadgetName, Battery battery, float displaySize) {
        super(GadgetType.WATCH, gadgetName, battery);
        this.displaySize = displaySize;
    }

    public SmartWatch(GadgetName gadgetName, String dimensions, Color color, int weight, Battery battery, float displaySize) {
        super(GadgetType.WATCH, gadgetName, dimensions, color, weight, battery);
        this.displaySize = displaySize;
    }

    public float getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(float displaySize) {
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getGadgetName().getGadgetBrand() + '\'' +
                ", model='" + this.getGadgetName().getGadgetModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
                ", displaySize=" + displaySize +
                ", " + this.getBattery().toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmartWatch that = (SmartWatch) o;

        return Float.compare(that.getDisplaySize(), getDisplaySize()) == 0;
    }

    @Override
    public int hashCode() {
        return (getDisplaySize() != 0.0f ? Float.floatToIntBits(getDisplaySize()) : 0);
    }
}

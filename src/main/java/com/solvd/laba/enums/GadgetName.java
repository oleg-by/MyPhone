package com.solvd.laba.enums;

public enum GadgetName {
    IPHONE(GadgetBrand.APPLE, GadgetModel.I13PROMAX),
    SAMS(GadgetBrand.SAMSUNG, GadgetModel.GALAXYS22U),
    IPAD(GadgetBrand.APPLE, GadgetModel.IPADPRO),
    IWATCH(GadgetBrand.APPLE, GadgetModel.WATCHS7),
    MI11(GadgetBrand.XIAOMI, GadgetModel.MI11U),
    HUA(GadgetBrand.HUAWEI, GadgetModel.P50PRO),
    SONYXP(GadgetBrand.SONY, GadgetModel.XPERIAPROI),
    HONOR30(GadgetBrand.HONOR, GadgetModel.H30PRO);

    private final GadgetBrand gadgetBrand;
    private final GadgetModel gadgetModel;

    GadgetName(GadgetBrand gadgetBrand, GadgetModel gadgetModel) {
        this.gadgetBrand = gadgetBrand;
        this.gadgetModel = gadgetModel;
    }

    public GadgetBrand getGadgetBrand() {
        return gadgetBrand;
    }

    public GadgetModel getGadgetModel() {
        return gadgetModel;
    }

    @Override
    public String toString() {
        return gadgetBrand + " " + gadgetModel;
    }
}

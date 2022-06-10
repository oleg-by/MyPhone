package com.solvd.laba.model;

import com.solvd.laba.interfaces.builder.CpuBuilder;

public class CpuBuilderImpl implements CpuBuilder {

    Cpu cpu = new Cpu();

    @Override
    public CpuBuilder setCpuModel(String name) {
        cpu.setCpuModel(name);
        return this;
    }

    @Override
    public CpuBuilder setCpuSpeed(int speed) {
        cpu.setCpuSpeed(speed);
        return this;
    }

    @Override
    public Cpu build() {
        return cpu;
    }
}

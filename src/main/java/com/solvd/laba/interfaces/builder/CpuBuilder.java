package com.solvd.laba.interfaces.builder;

import com.solvd.laba.model.Cpu;

public interface CpuBuilder {
    CpuBuilder setCpuModel(String name);
    CpuBuilder setCpuSpeed(int speed);
    Cpu build();
}

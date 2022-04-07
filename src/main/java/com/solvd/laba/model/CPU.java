package main.java.com.solvd.laba.model;

public class CPU {
    private String cpuModel;
    private int cpuSpeed;

    public CPU() {
    }

    public CPU(String cpuModel, int cpuSpeed) {
        this.cpuModel = cpuModel;
        this.cpuSpeed = cpuSpeed;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public void setCpuSpeed(int cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public int getCpuSpeed() {
        return cpuSpeed;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "cpuModel='" + cpuModel + '\'' +
                ", cpuSpeed=" + cpuSpeed +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CPU cpu = (CPU) obj;

        if (getCpuSpeed() != cpu.getCpuSpeed()) return false;
        return getCpuModel() != null ? getCpuModel().equals(cpu.getCpuModel()) : cpu.getCpuModel() == null;
    }

    @Override
    public int hashCode() {
        int result = getCpuModel() != null ? getCpuModel().hashCode() : 0;
        result = 31 * result + getCpuSpeed();
        return result;
    }
}

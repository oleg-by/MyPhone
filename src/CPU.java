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

    public void cpuInfo() {
        System.out.println("CPU is " + this.cpuModel + ".");
        System.out.println("CPU speed is " + this.cpuSpeed + " MHz.");
    }
}

package autoPractice.impl;

import autoPractice.Engine;

public class ElectricEngine implements Engine {
    private final int performance;
    private final int voltage;

    public ElectricEngine(int performance, int voltage) {
        this.performance = performance;
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "performance=" + performance +
                ", voltage=" + voltage +
                '}';
    }
}

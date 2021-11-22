package autoPractice;

import java.util.Arrays;

public class AutoPractice {
    private final Engine engine;
    private final Wheel[] wheels;
    private final String type;

    public AutoPractice(Engine engine, Wheel[] wheels, String type) {
        this.engine = engine;
        this.wheels = wheels;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine.toString() +
                ", wheels=" + wheels[0].toString() +
                ", type='" + type + '\'' +
                '}';
    }
}

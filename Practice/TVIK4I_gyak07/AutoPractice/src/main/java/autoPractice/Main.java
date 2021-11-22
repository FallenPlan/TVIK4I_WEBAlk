package autoPractice;

import autoPractice.impl.TraditionalEngine;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        Engine engine18 = new TraditionalEngine(240, 2100);

        AutoPractice audiA7 = new AutoPractice(engine18, get4wheel(), "Audi A7");

        out.println(audiA7);
    }

    public static Wheel[] get4wheel() {
        Wheel[] wheels = new Wheel[4];

        for (int i = 0; i < 4; i++) {
            wheels[i] = new autoPractice.impl.Wheel(225, 17, 85);
        }

        return wheels;
    }
}

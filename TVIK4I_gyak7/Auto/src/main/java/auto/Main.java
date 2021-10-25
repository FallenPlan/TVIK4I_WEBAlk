package auto;

import auto.impl.BelsoEgesuMotor;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Motor motor16 = new BelsoEgesuMotor(180, 1600);

        Auto opelAstra = new Auto(motor16, get4kerek(), "Opel Astra");

        out.println(opelAstra);
    }

    public static Kerek[] get4kerek() {
        Kerek[] kerekek = new Kerek[4];

        for (int i = 0; i < 4; i++) {
            kerekek[i] = new auto.impl.Kerek(205, 15, 65);
        }

        return kerekek;
    }
}

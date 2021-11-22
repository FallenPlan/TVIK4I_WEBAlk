package autoPractice.impl;

public class Wheel implements autoPractice.Wheel {
    private final int width;
    private final int diameter;
    private final int cloakHeight;

    public Wheel(int width, int diameter, int cloakHeight) {
        this.width = width;
        this.diameter = diameter;
        this.cloakHeight = cloakHeight;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                width +
                "/" + cloakHeight +
                "R" + diameter +
                '}';
    }
}

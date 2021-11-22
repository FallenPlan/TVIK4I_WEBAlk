package autoPractice.impl;

public class TraditionalEngine implements autoPractice.Engine {
    private final int horsepower;
    private final int ccm;

    public TraditionalEngine(int horsepower, int ccm) {
        this.horsepower = horsepower;
        this.ccm = ccm;
    }

    @Override
    public String toString() {
        return "TraditionalEngine{" +
                "horsepower=" + horsepower +
                ", ccm=" + ccm +
                '}';
    }
}

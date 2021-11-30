package top.irvingsoft.code.containers.hashcode;

import java.util.Random;

public class Prediction {

    private static final Random  rand   = new Random(47);
    private final        boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter";
        } else {
            return "Early Spring";
        }
    }
}

package hospitalmanagement.util;

import java.util.Date;

public class Random {
    private static final java.util.Random random = new java.util.Random(new Date().getTime());

    public static int i(int bound) {
        return random.nextInt(bound);
    }

    public static float f() {
        return random.nextFloat();
    }
}

package manufacturerproduction.util;

import java.util.Date;

public class Random {
    private static java.util.Random rand = new java.util.Random(new Date().getTime());

    /**
     * returns a random integer between [lo, hi)
     * @param lo lower bound, inclusive
     * @param hi higher bound, exclusive
     * @return a random integer between the given interval
     */
    public static int i(int lo, int hi) {
        return rand.nextInt(hi - lo) + lo;
    }
}

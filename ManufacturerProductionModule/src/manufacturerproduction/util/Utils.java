package manufacturerproduction.util;

import java.util.Date;
import java.util.Random;

public class Utils {
    private static Random rand = new Random(new Date().getTime());

    public static void indent(StringBuilder builder, int depth) {
        for(int i = 0; i < depth; ++i)
            builder.append('\t');
    }

    /**
     * returns a random integer between [lo, hi)
     * @param lo lower bound, inclusive
     * @param hi higher bound, exclusive
     * @return a random integer between the given interval
     */
    public static int randomInt(int lo, int hi) {
        return rand.nextInt(hi - lo) + lo;
    }
}

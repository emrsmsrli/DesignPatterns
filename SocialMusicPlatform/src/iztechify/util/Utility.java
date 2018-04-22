package iztechify.util;

public class Utility {
    public static int clamp(int lo, int number, int hi) {
        return Math.max(lo, Math.min(number, hi));
    }
}

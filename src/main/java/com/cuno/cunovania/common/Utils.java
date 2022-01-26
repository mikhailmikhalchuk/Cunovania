package com.cuno.cunovania.common;

public class Utils {
    public static <T extends Comparable<T>> T clamp(T val, T min, T max) {
        if (val.compareTo(max) > 0) {
            return max;
        }
        if (val.compareTo(min) < 0) {
            return min;
        }
        return val;
    }
}

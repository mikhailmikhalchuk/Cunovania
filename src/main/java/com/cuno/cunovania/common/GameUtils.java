package com.cuno.cunovania.common;

import java.awt.*;

public class GameUtils {
    public static <T extends Comparable<T>> T clamp(T val, T min, T max) {
        if (val.compareTo(max) > 0) {
            return max;
        }
        if (val.compareTo(min) < 0) {
            return min;
        }
        return val;
    }

    public static double toRotation(int x, int y) {
        return Math.atan2((float)x, (float)y);
    }

    public static double toRotation(Vector2 vector) {
        return Math.atan2(vector.X, vector.Y);
    }
}
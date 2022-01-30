package com.cuno.cunovania.common;

import java.awt.*;

public class Vector2 {
    public static Vector2 Zero = new Vector2(0);
    public static Vector2 One = new Vector2(1);

    public float X;
    public float Y;

    public Vector2(float val) {
        X = Y = val;
    }

    public Vector2(float x, float y) {
        X = x;
        Y = y;
    }

    public Vector2 add(Vector2 vector) {
        return new Vector2(X + vector.X, Y + vector.Y);
    }

    public Vector2 subtract(Vector2 vector) {
        return new Vector2(X - vector.X, Y - vector.Y);
    }

    public Vector2 multiply(float value) {
        return new Vector2(X * value, Y * value);
    }

    public Vector2 multiply(Vector2 vector) {
        return new Vector2(X * vector.X, Y * vector.Y);
    }

    public Vector2 divide(float value) {
        return new Vector2(X / value, Y / value);
    }

    public Vector2 divide(Vector2 vector) {
        return new Vector2(X / vector.X, Y / vector.Y);
    }

    public static Vector2 fromPoint(Point point) {
        return new Vector2(point.x, point.y);
    }

    public void addToVector(Vector2 vector) {
        X += vector.X;
        Y += vector.Y;
    }

    public Vector2 inverse() {
        return new Vector2(-X, -Y);
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}

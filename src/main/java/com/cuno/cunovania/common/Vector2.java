package com.cuno.cunovania.common;

public class Vector2
{
    public static Vector2 Zero = new Vector2(0);
    public static Vector2 One = new Vector2(1);

    public float X;
    public float Y;

    public Vector2() {
        X = 0.0f;
        Y = 0.0f;
    }

    public Vector2(float size) {
        X = Y = size;
    }

    public Vector2(float x, float y) {
        X = x;
        Y = y;
    }

    public boolean equals(Vector2 vector) {
        return (X == vector.X && this.Y == vector.Y);
    }

    public void add(Vector2 vector) {
        X += vector.X;
        Y += vector.Y;
    }

    public void subtract(Vector2 vector) {
        X -= vector.X;
        Y -= vector.Y;
    }
}
package com.cuno.cunovania.content;

import com.cuno.cunovania.Cunovania;
import com.cuno.cunovania.common.DrawUtils;
import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Bullet {
    public float X;
    public float Y;
    public float velocityX;
    public float velocityY;
    public double rotation;

    public static List<Bullet> allBullets = new ArrayList<>();

    public Bullet(Point position, Point velocity) {
        X = position.x;
        Y = position.y;
        velocityX = velocity.x;
        velocityY = velocity.y;
        allBullets.add(this);
    }

    public void update() {
        X += velocityX;
        Y += velocityY;
    }

    public void draw(Graphics2D g2d, JPanel observer) {
        DrawUtils.drawRotatedImage(g2d, Cunovania.MagicPixel, (int)X, (int)Y, 25, 25, rotation, (int)X, (int)Y, observer);
    }
}

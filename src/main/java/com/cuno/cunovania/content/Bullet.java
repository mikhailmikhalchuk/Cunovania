package com.cuno.cunovania.content;

import com.cuno.cunovania.Cunovania;
import com.cuno.cunovania.common.DrawUtils;
import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Input;
import com.cuno.cunovania.common.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Bullet {
    public Vector2 position;
    public Vector2 velocity;
    public double rotation;

    public static List<Bullet> allBullets = new ArrayList<>();

    public Bullet(Vector2 position, Vector2 velocity, double rotation) {
        this.position = new Vector2(position.X, position.Y);
        this.velocity = new Vector2(velocity.X, velocity.Y);
        this.rotation = rotation;
        allBullets.add(this);
    }

    public void update() {
        position = position.add(velocity);
        //System.out.println(position);
    }

    public void draw(Graphics2D g2d, JPanel observer) {
        DrawUtils.drawRotatedImage(g2d, Cunovania.MagicPixel, (int)position.X, (int)position.Y, 25, 25, rotation, (int)position.X, (int)position.Y, observer);
    }
}

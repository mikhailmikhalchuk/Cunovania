package com.cuno.cunovania;

import com.cuno.cunovania.common.Vector2;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Player {
    public int width;
    public int height;
    public Vector2 position;
    public Vector2 velocity;
    public Image texture;

    public Player() {
        texture = new ImageIcon("src/main/resources/paul.jpg").getImage();
        width = 50;
        height = 100;
        position = Vector2.Zero;
        velocity = Vector2.Zero;
    }

    public void update() {
        position.add(velocity);
        velocity = Vector2.Zero;
    }
}

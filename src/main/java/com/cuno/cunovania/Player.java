package com.cuno.cunovania;

import com.cuno.cunovania.common.Utils;
import com.sun.tools.javac.Main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {
    public int width;
    public int height;
    public float X;
    public float Y;
    public float velocityX;
    public float velocityY;
    public Image texture;

    public boolean leftDown;
    public boolean rightDown;
    public boolean jumpDown;

    public boolean onGround;

    public Player() {
        texture = new ImageIcon("src/main/resources/paul.jpg").getImage();
        width = 50;
        height = 100;
        X = 0;
        Y = 200;
        leftDown = false;
        rightDown = false;
        jumpDown = false;
        onGround = true;
        velocityX = 0;
        velocityY = 0;
    }

    public void update() {
        if (leftDown) {
            velocityX -= 5;
        }
        if (rightDown) {
            velocityX += 5;
        }
        X += velocityX;
        Y += velocityY;
        if (Y <= 200) {
            velocityY += 0.2f;
            onGround = false;
        }
        if (Y > 200) {
            velocityY = 0.0f;
            onGround = true;
        }
        velocityX = 0;
        X = Utils.clamp(X, 0f, (float)Cunovania.Instance.getSize().width - width);
    }
}

package com.cuno.cunovania;

import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Vector2;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {
    public int width;
    public int height;
    public Vector2 position;
    public Vector2 velocity;
    public Image texture;

    public boolean leftDown;
    public boolean rightDown;
    public boolean jumpDown;

    public boolean onGround;

    public Player() {
        texture = new ImageIcon("src/main/resources/paul.jpg").getImage();
        width = 50;
        height = 100;
        leftDown = false;
        rightDown = false;
        jumpDown = false;
        onGround = true;
        position = new Vector2(50, 100);
        velocity = Vector2.Zero;
    }

    public void update() {
        if (leftDown) {
            velocity.X -= 5;
        }
        if (rightDown) {
            velocity.X += 5;
        }
        position.X += velocity.X;
        position.Y += velocity.Y;
        if (position.Y <= 200) {
            velocity.Y += 0.2f;
            onGround = false;
        }
        if (position.Y > 200) {
            velocity.Y = 0.0f;
            onGround = true;
        }
        velocity.X = 0;
        position.X = GameUtils.clamp(position.X, 0f, (float)Cunovania.Instance.getSize().width - width);
    }
}

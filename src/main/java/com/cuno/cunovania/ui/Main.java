package com.cuno.cunovania.ui;

import com.cuno.cunovania.Player;
import com.cuno.cunovania.common.*;
import com.cuno.cunovania.content.RoomObject;
import com.cuno.cunovania.content.entities.Bullet;
import com.cuno.cunovania.core.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main extends JPanel implements ActionListener {
    private Player player;
    private Timer timer;
    public static ArrayList<Entity> ActiveEntities;
    public static Image MagicPixel;

    public Main() {
        initData();
        addKeyListener(new TAdapterKeys());
        addMouseListener(new TAdapterMouse());
        setBackground(Color.BLACK);

        player = new Player();
        ActiveEntities.add(player);

        timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
    }

    private void initData() {
        ActiveEntities = new ArrayList<>();
        MagicPixel = new ImageIcon("src/main/resources/MagicPixel.png").getImage();
        RoomObject obj = new RoomObject(new Rectangle(100, 200, 100, 100));
        ActiveEntities.add(obj);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Entity entity : ActiveEntities)
        {
            entity.draw(this, g2d);
        }

        if (Input.mouseState != null) {

            Vector2 playerCenter = player.EHitboxable.center();
            double theta = -GameUtils.toRotation(Input.mouseState.getLocation().x - (int)playerCenter.X, Input.mouseState.getLocation().y - (int)playerCenter.Y) + Math.PI / 2;

            DrawUtils.drawRotatedImage(g2d, MagicPixel, (int)playerCenter.X, (int)playerCenter.Y, 50, 10, theta, (int)playerCenter.X, (int)playerCenter.Y, this);

            g2d.drawImage(MagicPixel, (int)playerCenter.X, (int)playerCenter.Y, 10, 10, this);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Entity entity : ActiveEntities)
        {
            entity.update();
        }

        Input.handleInput();
        repaint();
    }

    private class TAdapterMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Input.mouseDown = true;
            Vector2 playerCenter = player.EHitboxable.center();
            double theta = Math.atan2(Input.mouseState.getLocation().x - playerCenter.X, Input.mouseState.getLocation().y - playerCenter.Y);
            Vector2 vel = new Vector2((float)((player.bulletVelocity) * Math.cos(theta)), (float)((player.bulletVelocity) * Math.sin(theta)));


            //System.out.println(new Vector2((float)(pos.X * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y)), (float)(pos.Y * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y))));
            Bullet bullet = new Bullet(playerCenter, new Vector2(vel.X - MathUtils.PI, -(vel.Y - MathUtils.PI)), theta);
            ActiveEntities.add(bullet);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Input.mouseDown = false;
        }
    }

    private class TAdapterKeys extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                player.leftDown = true;
            }
            if (key == KeyEvent.VK_D) {
                player.rightDown = true;
            }
            if (key == KeyEvent.VK_SPACE && player.onGround) {
                player.jumpDown = true;
            }
            if (key == KeyEvent.VK_S) {
                player.EMovable.Velocity.Y += 1;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                player.leftDown = false;
            }
            if (key == KeyEvent.VK_D) {
                player.rightDown = false;
            }
            if (key == KeyEvent.VK_SPACE) {
                player.jumpDown = false;
            }
        }
    }
}
package com.cuno.cunovania.ui;

import com.cuno.cunovania.Cunovania;
import com.cuno.cunovania.Player;
import com.cuno.cunovania.common.DrawUtils;
import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Input;
import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.content.Bullet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Window extends JPanel implements ActionListener {
    private Player player;
    private Timer timer;

    public Window() {
        addKeyListener(new TAdapterKeys());
        addMouseListener(new TAdapterMouse());
        setBackground(Color.BLACK);

        player = new Player();

        timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.texture, (int)player.position.X, (int)player.position.Y, player.width, player.height, this);
        if (Input.mouseState != null) {

            double theta = -GameUtils.toRotation(Input.mouseState.getLocation().x - ((int)player.position.X + player.width / 2), Input.mouseState.getLocation().y - ((int)player.position.Y + player.height / 2)) + Math.PI / 2;

            DrawUtils.drawRotatedImage(g2d, Cunovania.MagicPixel, (int)player.position.X + player.width / 2, (int)player.position.Y + player.height / 2, 50, 10, theta, (int)player.position.X + player.width / 2, (int)player.position.Y + player.height / 2, this);

            g2d.drawImage(Cunovania.MagicPixel, (int)player.position.X + player.width / 2, (int)player.position.Y + player.height / 2, 10, 10, this);
        }

        for (int i = 0; i < Bullet.allBullets.size(); i++) {
            Bullet.allBullets.get(i).draw(g2d, this);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        Input.handleInput();
        for (int i = 0; i < Bullet.allBullets.size(); i++) {
            Bullet.allBullets.get(i).update();
        }

        repaint();
    }

    private class TAdapterMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Input.mouseDown = true;
            double theta = -GameUtils.toRotation(Input.mouseState.getLocation().x - ((int)player.position.X + player.width / 2), Input.mouseState.getLocation().y - ((int)player.position.Y + player.height / 2)) + Math.PI / 2;
            Vector2 pos = Vector2.fromPoint(Input.mouseState.getLocation()).subtract(player.position);

            pos = pos.divide(80f);
            System.out.println(new Vector2((float)(pos.X * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y)), (float)(pos.Y * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y))));
            new Bullet(pos, new Vector2((float)(pos.X * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y)), (float)(pos.Y * Math.sqrt(pos.X * pos.X + pos.Y * pos.Y))), theta);
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
                player.velocity.Y = -5;
                player.jumpDown = true;
                player.onGround = false;
            }
            if (key == KeyEvent.VK_S) {
                player.velocity.Y += 1;
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

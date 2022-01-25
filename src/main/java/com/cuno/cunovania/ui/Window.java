package com.cuno.cunovania.ui;

import com.cuno.cunovania.Player;
import com.cuno.cunovania.common.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JPanel implements ActionListener {
    private Player player;
    private Timer timer;

    public Window() {
        addKeyListener(new TAdapter());
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

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();

        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                player.velocity.X -= 1;
            }
            if (key == KeyEvent.VK_D) {
                System.out.println("test");
                player.velocity.X += 1;
            }
            if (key == KeyEvent.VK_W) {
                player.velocity.Y += 1;
            }
            if (key == KeyEvent.VK_S) {
                player.velocity.Y -= 1;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                player.velocity = Vector2.Zero;
            }
            if (key == KeyEvent.VK_D) {
                System.out.println("test2");
                player.velocity.X = 0;
            }
            if (key == KeyEvent.VK_W) {
                player.velocity = Vector2.Zero;
            }
            if (key == KeyEvent.VK_S) {
                player.velocity = Vector2.Zero;
            }
        }
    }
}

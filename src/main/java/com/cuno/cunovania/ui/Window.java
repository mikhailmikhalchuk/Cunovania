package com.cuno.cunovania.ui;

import com.cuno.cunovania.Player;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Window extends JPanel implements ActionListener {
    public ArrayList<Entity> ActiveEntities;
    private Player player;
    private Timer timer;

    public Window() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);

        ActiveEntities = new ArrayList<Entity>();
        player = new Player();
        ActiveEntities.add(player);

        timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Entity entity : ActiveEntities)
        {
            entity.Draw(this, g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Entity entity : ActiveEntities)
        {
            entity.Update();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {
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
                player.EMovable.VelocityY = -5;
                player.jumpDown = true;
                player.onGround = false;
            }
            if (key == KeyEvent.VK_S) {
                player.EMovable.VelocityY += 1;
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

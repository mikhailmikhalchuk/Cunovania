package com.cuno.cunovania.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JPanel implements ActionListener {
    public Window() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        ImageIcon ii = new ImageIcon("src/main/resources/paul.jpg");
        Image image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_L) {
                System.out.println("L pressed");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_DOWN) {
                System.out.println("Arrow down released");
            }
        }
    }
}

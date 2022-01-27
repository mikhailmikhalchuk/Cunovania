package com.cuno.cunovania;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.cuno.cunovania.ui.Window;

public class Cunovania extends JFrame {
    public static Window GameWindow;
    public static Cunovania Instance;
    public static Image MagicPixel = new ImageIcon("src/main/resources/MagicPixel.png").getImage();

    public Cunovania() {
        initGame();
    }

    private void initGame() {
        GameWindow = new Window();
        add(GameWindow);

        setLocation(0, 0);
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cunovania");
    }

    public static void main(String[] args) {
        System.out.println("sus");
        EventQueue.invokeLater(() -> {
            Instance = new Cunovania();
            Instance.setVisible(true);
        });
    }
}
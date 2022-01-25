package com.cuno.cunovania;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.cuno.cunovania.ui.Window;

public class Cunovania extends JFrame {
    public Cunovania() {
        initGame();
    }

    private void initGame() {
        add(new Window());

        setLocationRelativeTo(null);
        setSize(1400, 1400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cunovania");
    }

    public static void main(String[] args) {
        System.out.println("sus");
        EventQueue.invokeLater(() -> {
            Cunovania game = new Cunovania();
            game.setVisible(true);
        });
    }
}
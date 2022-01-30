package com.cuno.cunovania;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.ui.Main;

public class Program extends JFrame {
    public static Main Main;
    public static Program Instance;

    public Program() {
        initGame();
    }

    private void initGame() {
        Main = new Main();
        add(Main);

        setLocation(0, 0);
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cunovania");
    }

    public static void main(String[] args) {
        System.out.println("sus");
        EventQueue.invokeLater(() -> {
            Instance = new Program();
            Instance.setVisible(true);
        });
    }
}
package com.cuno.cunovania.common;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class DrawUtils {
    public static void drawRotatedImage(Graphics2D g2d, Image image, int posX, int posY, int width, int height, double rotation, int anchorX, int anchorY, JPanel observer) {
        AffineTransform backup = g2d.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(rotation, anchorX, anchorY);

        g2d.setTransform(a);

        g2d.drawImage(image, posX, posY, width, height, observer);

        g2d.setTransform(backup);
    }
}
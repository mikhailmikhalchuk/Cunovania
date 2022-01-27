package com.cuno.cunovania.content.entities;

import com.cuno.cunovania.Cunovania;
import com.cuno.cunovania.common.DrawUtils;
import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Input;
import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.content.entityComponents.EMovable;
import com.cuno.cunovania.content.entityComponents.EPositionable;
import com.cuno.cunovania.content.entityComponents.ESizable;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Entity {
    public EPositionable EPositionable;
    public ESizable ESizable;
    public EMovable EMovable;
    public double rotation;

    public Bullet(Vector2 position, Vector2 velocity, double rotation) {
        EPositionable = new EPositionable(position);
        ESizable = new ESizable(new Vector2(25));
        EMovable = new EMovable(EPositionable, velocity);
        AddComponent(EPositionable);
        AddComponent(ESizable);
        AddComponent(EMovable);

        this.rotation = rotation;
    }

    @Override
    public void DrawSelf(ImageObserver observer, Graphics2D graphics2D)
    {
        DrawUtils.drawRotatedImage(graphics2D, Cunovania.MagicPixel, (int)EPositionable.Position.X, (int)EPositionable.Position.Y, (int)ESizable.Dimensions.X, (int)ESizable.Dimensions.Y, rotation, (int)EPositionable.Position.X, (int)EPositionable.Position.Y, (JPanel)observer);
    }
}
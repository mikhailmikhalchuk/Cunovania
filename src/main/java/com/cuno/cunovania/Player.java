package com.cuno.cunovania;

import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.content.entityComponents.*;
import com.cuno.cunovania.core.entity.Entity;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Entity
{
    public EPositionable EPositionable;
    public ESizable ESizable;
    public EMovable EMovable;
    public EBasicDrawable EBasicDrawable;
    public EHitboxable EHitboxable;
    public Image texture;

    public boolean leftDown;
    public boolean rightDown;
    public boolean jumpDown;

    public boolean onGround;

    public Player()
    {
        texture = new ImageIcon("src/main/resources/paul.jpg").getImage();
        EPositionable = new EPositionable(new Vector2(0, 200));
        ESizable = new ESizable(new Vector2(50, 100));
        EMovable = new EMovable(EPositionable, new Vector2(0, 0));
        EBasicDrawable = new EBasicDrawable(EPositionable, ESizable, texture);
        EHitboxable = new EHitboxable(EPositionable, ESizable);
        AddComponent(EPositionable);
        AddComponent(ESizable);
        AddComponent(EMovable);
        AddComponent(EBasicDrawable);
        AddComponent(EHitboxable);
        leftDown = false;
        rightDown = false;
        jumpDown = false;
        onGround = true;
    }

    @Override
    public void UpdateSelf()
    {
        System.out.println(EPositionable.Position.toString());
        if (leftDown)
        {
            EMovable.Velocity.X = -5;
        }
        else if (rightDown)
        {
            EMovable.Velocity.X = 5;
        }
        else
        {
            EMovable.Velocity.X = 0;
        }

        if (EPositionable.Position.Y <= 200)
        {
            EMovable.Velocity.Y += 0.2f;
            onGround = false;
        }
        else if (EPositionable.Position.Y > 200)
        {
            EMovable.Velocity.Y = 0.0f;
            onGround = true;
        }

        EPositionable.Position.X = GameUtils.clamp(EPositionable.Position.X, 0f, Cunovania.Instance.getSize().width - ESizable.Dimensions.X);
    }
}
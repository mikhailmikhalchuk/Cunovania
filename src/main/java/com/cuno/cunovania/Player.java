package com.cuno.cunovania;

import com.cuno.cunovania.common.Utils;
import com.cuno.cunovania.content.entityComponents.EBasicDrawable;
import com.cuno.cunovania.content.entityComponents.EMovable;
import com.cuno.cunovania.content.entityComponents.EPositionable;
import com.cuno.cunovania.content.entityComponents.ESizable;
import com.cuno.cunovania.core.entity.Entity;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Entity
{
    public EPositionable EPositionable;
    public ESizable ESizable;
    public EMovable EMovable;
    public EBasicDrawable EBasicDrawable;
    public Image texture;

    public boolean leftDown;
    public boolean rightDown;
    public boolean jumpDown;

    public boolean onGround;

    public Player()
    {
        texture = new ImageIcon("src/main/resources/paul.jpg").getImage();
        EPositionable = new EPositionable(0, 200);
        ESizable = new ESizable(50, 100);
        EMovable = new EMovable(EPositionable, 0, 0);
        EBasicDrawable = new EBasicDrawable(EPositionable, ESizable, texture);
        AddComponent(EPositionable);
        AddComponent(ESizable);
        AddComponent(EMovable);
        AddComponent(EBasicDrawable);
        leftDown = false;
        rightDown = false;
        jumpDown = false;
        onGround = true;
    }

    @Override
    public void UpdateSelf()
    {
        if (leftDown)
        {
            EMovable.VelocityX = -5;
        }
        else if (rightDown)
        {
            EMovable.VelocityX = 5;
        }
        else
        {
            EMovable.VelocityX = 0;
        }

        if (EPositionable.Y <= 200)
        {
            EMovable.VelocityY += 0.2f;
            onGround = false;
        }
        else if (EPositionable.Y > 200)
        {
            EMovable.VelocityY = 0.0f;
            onGround = true;
        }

        EPositionable.X = Utils.clamp(EPositionable.X, 0, Cunovania.Instance.getSize().width - ESizable.Width);
    }
}

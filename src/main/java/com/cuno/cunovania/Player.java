package com.cuno.cunovania;

import com.cuno.cunovania.common.GameUtils;
import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.content.entityComponents.*;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;
import com.cuno.cunovania.ui.Main;

import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends Entity
{
    public EPositionable EPositionable;
    public ESizable ESizable;
    public EMovable EMovable;
    public EBasicDrawable EBasicDrawable;
    public EHitboxable EHitboxable;
    public Image texture;

    public int bulletVelocity;

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
        addComponent(EPositionable);
        addComponent(ESizable);
        addComponent(EMovable);
        addComponent(EBasicDrawable);
        addComponent(EHitboxable);
        bulletVelocity = 10;
        leftDown = false;
        rightDown = false;
        jumpDown = false;
        onGround = true;
    }

    @Override
    public void updateSelf()
    {
        //System.out.println(EPositionable.Position.toString());
        Vector2 origVel = EMovable.Velocity;
        Vector2 origPos = EPositionable.Position;
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
        if (jumpDown && onGround) {
            EMovable.Velocity.Y = -5f;
            onGround = false;
        }

        for (Entity entity : Main.ActiveEntities) {
            System.out.println(entity.getClass());
            if (entity.hasComponent(com.cuno.cunovania.content.entityComponents.EHitboxable.class) && entity != this) {
                System.out.println("y");
                Rectangle playerPos = new Rectangle((int)EPositionable.Position.X, (int)EPositionable.Position.Y, (int)ESizable.Dimensions.X, (int)ESizable.Dimensions.Y);
                EPositionable ePos = (com.cuno.cunovania.content.entityComponents.EPositionable) entity.getComponent(com.cuno.cunovania.content.entityComponents.EPositionable.class);
                ESizable eSize = (com.cuno.cunovania.content.entityComponents.ESizable) entity.getComponent(com.cuno.cunovania.content.entityComponents.ESizable.class);
                Rectangle entPos = new Rectangle((int)ePos.Position.X, (int)ePos.Position.Y, (int)eSize.Dimensions.X, (int)eSize.Dimensions.Y);
                if (entPos.intersects(playerPos)) {
                    System.out.println("ynn");
                    //EMovable.Velocity = origVel;
                    //EPositionable.Position = origPos;
                    break;
                }
            }
        }
        EPositionable.Position.X = GameUtils.clamp(EPositionable.Position.X, 0f, Program.Instance.getSize().width - ESizable.Dimensions.X);
    }
}
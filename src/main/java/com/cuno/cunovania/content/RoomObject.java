package com.cuno.cunovania.content;

import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.content.entityComponents.EHitboxable;
import com.cuno.cunovania.content.entityComponents.EPositionable;
import com.cuno.cunovania.content.entityComponents.ESizable;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.ui.Main;

import java.awt.*;
import java.awt.image.ImageObserver;

public class RoomObject extends Entity {
    public EPositionable EPositionable;
    public ESizable ESizable;
    public EHitboxable EHitboxable;
    public Room Parent;
    public boolean active;

    public RoomObject(Rectangle hitbox) {
        EPositionable = new EPositionable(new Vector2(hitbox.x, hitbox.y));
        ESizable = new ESizable(new Vector2(hitbox.width, hitbox.height));
        EHitboxable = new EHitboxable(EPositionable, ESizable);
        addComponent(EPositionable);
        addComponent(ESizable);
        addComponent(EHitboxable);
    }

    public RoomObject(Vector2 position, Vector2 size) {
        EPositionable = new EPositionable(position);
        ESizable = new ESizable(size);
        EHitboxable = new EHitboxable(EPositionable, ESizable);
        addComponent(EPositionable);
        addComponent(ESizable);
        addComponent(EHitboxable);
    }

    @Override
    public void drawSelf(ImageObserver observer, Graphics2D graphics2D) {
        graphics2D.drawImage(Main.MagicPixel, (int)EPositionable.Position.X, (int)EPositionable.Position.Y, (int)ESizable.Dimensions.X, (int)ESizable.Dimensions.Y, observer);
    }
}

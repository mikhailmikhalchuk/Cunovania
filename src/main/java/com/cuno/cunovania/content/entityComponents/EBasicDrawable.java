package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.core.entity.EntityComponent;

import java.awt.*;
import java.awt.image.ImageObserver;

public class EBasicDrawable extends EntityComponent
{
    public EPositionable EPositionable;

    public ESizable ESizable;

    public Image Texture;

    public EBasicDrawable(EPositionable ePositionable, ESizable eSizable, Image texture)
    {
        EPositionable = ePositionable;
        ESizable = eSizable;
        Texture = texture;
    }

    @Override
    public void draw(ImageObserver observer, Graphics2D graphics2D)
    {
        graphics2D.drawImage(Texture, (int)EPositionable.Position.X, (int)EPositionable.Position.Y, (int)ESizable.Dimensions.X, (int)ESizable.Dimensions.Y, observer);
    }
}
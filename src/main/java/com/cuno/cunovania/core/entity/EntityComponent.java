package com.cuno.cunovania.core.entity;

import java.awt.*;
import java.awt.image.ImageObserver;

public class EntityComponent
{
    public void Update(Entity entity) { }

    public void Draw(ImageObserver observer, Graphics2D graphics2D) { }

    public void Merge(EntityComponent otherComponent) { }
}
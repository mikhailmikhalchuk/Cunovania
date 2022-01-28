package com.cuno.cunovania.core.entity;

import java.awt.*;
import java.awt.image.ImageObserver;

public class EntityComponent
{
    public void update(Entity entity) { }

    public void draw(ImageObserver observer, Graphics2D graphics2D) { }

    public void merge(EntityComponent otherComponent) { }
}
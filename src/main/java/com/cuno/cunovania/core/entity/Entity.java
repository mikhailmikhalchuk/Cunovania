package com.cuno.cunovania.core.entity;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.*;

public class Entity
{
    public final ArrayList<EntityComponent> ActiveComponents;

    public Entity()
    {
        ActiveComponents = new ArrayList<>();
    }

    public void updateSelf() { }

    public final void update()
    {
        updateSelf();

        for (EntityComponent component : ActiveComponents)
        {
            component.update(this);
        }
    }

    public void drawSelf(ImageObserver observer, Graphics2D graphics2D) { }

    public final void draw(ImageObserver observer, Graphics2D graphics2D)
    {
        drawSelf(observer, graphics2D);

        for (EntityComponent component : ActiveComponents)
        {
            component.draw(observer, graphics2D);
        }
    }

    public boolean addComponent(EntityComponent component)
    {
        boolean successfullyAdded = true;
        for (EntityComponent existingComponent : ActiveComponents)
        {
            if (existingComponent.getClass() != component.getClass())
            {
                continue;
            }

            existingComponent.merge(component);
            successfullyAdded = false;
            break;
        }

        ActiveComponents.add(component);
        return successfullyAdded;
    }

    public boolean removeComponent(Class<?> componentClass)
    {
        return ActiveComponents.removeIf(component -> component.getClass() == componentClass);
    }

    public boolean hasComponent(Class<?> componentClass) {
        return ActiveComponents.stream().anyMatch(component -> component.getClass() == componentClass);
    }

    public EntityComponent getComponent(Class<?> componentClass) {
        for (EntityComponent component : ActiveComponents) {
            if (component.getClass() == componentClass) {
                return component;
            }
        }
        return null; //socialcreditlost
    }
}
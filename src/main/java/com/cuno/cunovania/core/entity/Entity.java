package com.cuno.cunovania.core.entity;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.*;

public class Entity
{
    public final ArrayList<EntityComponent> ActiveComponents;

    public Entity()
    {
        ActiveComponents = new ArrayList<EntityComponent>();
    }

    public void UpdateSelf() { }

    public final void Update()
    {
        UpdateSelf();

        for (EntityComponent component : ActiveComponents)
        {
            component.Update(this);
        }
    }

    public void DrawSelf(ImageObserver observer, Graphics2D graphics2D) { }

    public final void Draw(ImageObserver observer, Graphics2D graphics2D)
    {
        DrawSelf(observer, graphics2D);

        for (EntityComponent component : ActiveComponents)
        {
            component.Draw(observer, graphics2D);
        }
    }

    public boolean AddComponent(EntityComponent component)
    {
        boolean successfullyAdded = true;
        for (EntityComponent existingComponent : ActiveComponents)
        {
            if (existingComponent.getClass() != component.getClass())
            {
                continue;
            }

            existingComponent.Merge(component);
            successfullyAdded = false;
            break;
        }

        ActiveComponents.add(component);
        return successfullyAdded;
    }

    public boolean RemoveComponent(Class<?> componentClass)
    {
        return ActiveComponents.removeIf(component -> component.getClass() == componentClass);
    }
}
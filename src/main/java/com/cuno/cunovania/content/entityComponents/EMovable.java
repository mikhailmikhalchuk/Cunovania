package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;

public class EMovable extends EntityComponent
{
    public EPositionable EPositionable;

    public Vector2 Velocity;

    public EMovable(EPositionable ePositionable, Vector2 velocity)
    {
        EPositionable = ePositionable;
        Velocity = velocity;
    }

    @Override
    public void update(Entity entity)
    {
        EPositionable.Position.addToVector(Velocity);
    }
}
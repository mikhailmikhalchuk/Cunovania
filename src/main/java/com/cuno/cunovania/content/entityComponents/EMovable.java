package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;

public class EMovable extends EntityComponent
{
    public EPositionable EPositionable;

    public float VelocityX;

    public float VelocityY;

    public EMovable(EPositionable ePositionable, float velocityX, float velocityY)
    {
        EPositionable = ePositionable;
        VelocityX = velocityX;
        VelocityY = velocityY;
    }

    @Override
    public void Update(Entity entity)
    {
        EPositionable.Add((int) VelocityX, (int)VelocityY);
    }
}
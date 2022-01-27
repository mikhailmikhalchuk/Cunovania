package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.core.entity.EntityComponent;

public class EPositionable extends EntityComponent
{
    public Vector2 Position;

    public EPositionable(Vector2 position)
    {
        Position = position;
    }
}
package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.core.entity.EntityComponent;

public class ESizable extends EntityComponent
{
    public Vector2 Dimensions;

    public ESizable(Vector2 dimensions)
    {
        Dimensions = dimensions;
    }
}
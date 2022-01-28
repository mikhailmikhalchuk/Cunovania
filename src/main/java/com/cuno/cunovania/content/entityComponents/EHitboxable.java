package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.common.Vector2;
import com.cuno.cunovania.core.entity.Entity;
import com.cuno.cunovania.core.entity.EntityComponent;

public class EHitboxable extends EntityComponent
{
    public EPositionable EPositionable;

    public ESizable ESizable;

    public EHitboxable(EPositionable ePositionable, ESizable eSizable)
    {
        EPositionable = ePositionable;
        ESizable = eSizable;
    }

    public Vector2 center()
    {
        return EPositionable.Position.add(ESizable.Dimensions.divide(2));
    }
}

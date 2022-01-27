package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.core.entity.EntityComponent;

public class EPositionable extends EntityComponent
{
    public int X;

    public int Y;

    public EPositionable(int x, int y)
    {
        X = x;
        Y = y;
    }

    public void Add(int addX, int addY)
    {
        X += addX;
        Y += addY;
    }

    public void Subtract(int subX, int subY)
    {
        X -= subX;
        Y -= subY;
    }

    public void Multiply(float multX, float multY)
    {
        X *= multX;
        Y *= multY;
    }

    public void Divide(float divX, float divY)
    {
        X /= divX;
        Y /= divY;
    }
}
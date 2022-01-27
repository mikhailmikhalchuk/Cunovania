package com.cuno.cunovania.content.entityComponents;

import com.cuno.cunovania.core.entity.EntityComponent;

public class ESizable extends EntityComponent
{
    public int Width;

    public int Height;

    public ESizable(int width, int height)
    {
        Width = width;
        Height = height;
    }
}
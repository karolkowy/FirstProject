package Collect.tiles;

import java.awt.image.BufferedImage;

import Collect.graphics.Assets;

public class StoneTile2 extends Tile
{

	public StoneTile2(int id) 
	{
		super(Assets.stone2, id);

	}
	@Override
	public boolean isSolid()
	{
		return true;
	}
	
}

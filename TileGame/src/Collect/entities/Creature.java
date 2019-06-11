package Collect.entities;

import Collect.Game;
import Collect.Handler;
import Collect.tiles.Tile;

public abstract class Creature extends Entity 
{
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 64; //ustawia rozmiary obiektu
	public static final int DEFAULT_HEIGH = 64; //etc.
	
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y,  int width, int height) 
	{
		super(handler, x, y, width, height);
		
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
	}

	public void move()
	{
		if(!checkEntityCollisions(xMove, 0))
			moveX();
		if(!checkEntityCollisions(0, yMove))
			moveY();
		 
	}
	

	
	//Kolizje
	public void moveX()
	{
		if(xMove > 0)
		{
			//ruch w prawo
			int tx = (int) (x + xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y)/Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y+ bounds.y +bounds.height)/Tile.TILEHEIGHT)) //jeœli nie ma kolizji to git
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILEWIDTH - bounds.x -bounds.width -1;
			}
		}
		else if (xMove < 0)
		{
			//ruch w lewo
			int tx = (int) (x + xMove + bounds.x)/Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y)/Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y +bounds.height)/Tile.TILEHEIGHT)) //jeœli nie ma kolizji to git
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x ;
			}
		}
	}
	
	public void moveY()
	{
		if(yMove < 0)
		{
			//ruch w górê
			int ty = (int) (y + yMove + bounds.y)/Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))
					{
						y += yMove;
					}
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y ;
			}
			
		}
		
		else if(yMove > 0)
		{
			//ruch w dó³
			int ty = (int) (y + yMove + bounds.y + bounds.height)/Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))
					{
						y += yMove;
					}
			else
			{
				y = ty * Tile.TILEHEIGHT  - bounds.y - bounds.height -1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	

	
	//metody get i set
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

								
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	

}

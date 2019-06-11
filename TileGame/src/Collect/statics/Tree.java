package Collect.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Collect.Handler;
import Collect.entities.Entity;
import Collect.graphics.Assets;
import Collect.tiles.Tile;

public class Tree extends StaticEntity
{
	
	public static int score=0;
	public Entity entity;
	
	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x=0;		//parametry kolizyjne
		bounds.y= 16;
		bounds.width= 8;
		bounds.height=32;
	}

	public  void die() {
		Random r = new Random(); 
		score+=1;
		//System.out.println("Your score:" +score);
		
			
		x = 64 + r.nextInt(700); 
		y = 64 + r.nextInt(700);
		
		
	};
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		
		g.setColor(Color.red);
		g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffset()), (int) (y+bounds.y-handler.getGameCamera().getyOffset()), (int) (bounds.width), (int) (bounds.height)); //prostok¹t do sprawdzania kolizji

	}

}

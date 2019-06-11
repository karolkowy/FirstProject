package Collect.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Collect.Game;
import Collect.Handler;
import Collect.graphics.Animation;
import Collect.graphics.Assets;
import Collect.tiles.Tile;

public class Player extends Creature
{
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;
	int score=0;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGH); //zmienne deafultowe mo¿na zmieniac dowolnie
		bounds.x=14;		//parametry kolizyjne
		bounds.y=32;
		bounds.width=32;
		bounds.height=32;
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animRight = new Animation(500, Assets.player_right);
		animLeft = new Animation(500, Assets.player_left);
	}

	@Override
	public void tick() 
	{
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		

		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		checkAttacks();
	}
	
	private void checkAttacks(){

		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().up){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().down){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().left){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().right){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
	
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
	};
	
	public  void die() {
		System.out.println("You lose");
	};
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove=-speed;
		if(handler.getKeyManager().down)
			yMove=+speed;
		if(handler.getKeyManager().left)
			xMove=-speed;
		if(handler.getKeyManager().right)
			xMove=+speed;
	}
	
	


	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()) , (int) (y - handler.getGameCamera().getyOffset()), width, height, null); //wszystko odwzoruje funkcja drawImage
		
		
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffset()), (int) (y+bounds.y-handler.getGameCamera().getyOffset()), (int) (bounds.width), (int) (bounds.height)); //prostok¹t do sprawdzania kolizji
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		if( xMove<0)
		{
			return animLeft.getCurrentFrame(); 
		}
		else if(xMove>0)
		{
			return animRight.getCurrentFrame();
		}
		else if( yMove<0)
		{
			return animUp.getCurrentFrame(); 
		}
		else if(yMove > 0)
		{
			return animDown.getCurrentFrame();
		}
		else
		{
			return Assets.player_down[1];
		}
	}

}

package Collect.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Collect.Handler;
import Collect.Game;
import Collect.graphics.Animation;
import Collect.graphics.Assets;
import Collect.states.State;
import Collect.tiles.Tile;

public class Opponent extends Creature
{
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Thread thread;
	int random;
	int directionchange=1;
	
	public Opponent(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGH);
		
		bounds.x=14;		//parametry kolizyjne
		bounds.y=32;
		bounds.width=32;
		bounds.height=32;
		
		//Animations
		animDown = new Animation(500, Assets.opponent_down);
		animUp = new Animation(500, Assets.opponent_up);
		animLeft = new Animation(500, Assets.opponent_left);
		animRight = new Animation(500, Assets.opponent_right);
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
		changingDirection();
		getInput();
		move();
		
		
		
	}

	
	//autorskie
	private void changingDirection() {
		//autorskie wypociny na odbijanie sie przeciwników 
		
		//odbijanie sie od przedmiotow
		if(checkEntityCollisions(xMove, 0f)) {directionchange*=-1;}
		if(checkEntityCollisions(0f, yMove)) {directionchange*=-1;}
		
		//odbijanie sie przy chodzenie w lewo
	int txmoveleft = (int) (x + xMove + bounds.x)/Tile.TILEWIDTH;
		if(collisionWithTile(txmoveleft, (int) (y + bounds.y)/Tile.TILEHEIGHT) ||
				collisionWithTile(txmoveleft, (int) (y+ bounds.y +bounds.height)/Tile.TILEHEIGHT)) {directionchange*=-1;}
		
		//odbijanie sie przy chodzenie w prawo
		int txmoveright = (int) (x + xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
		if(collisionWithTile(txmoveright, (int) (y + bounds.y)/Tile.TILEHEIGHT) ||
				collisionWithTile(txmoveright, (int) (y+ bounds.y +bounds.height)/Tile.TILEHEIGHT))  {directionchange*=-1;}
		
		//odbijanie sie przy chodzenie w góre
		int tymoveup = (int) (y + yMove + bounds.y)/Tile.TILEHEIGHT;
		if(!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH, tymoveup) ||
				!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, tymoveup)) {directionchange*=-1;}
		
		//odbijanie sie przy chodzenie w dó³
		int tymovedown = (int) (y + yMove + bounds.y + bounds.height)/Tile.TILEHEIGHT;
		
		if(!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH, tymovedown) ||
				!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, tymovedown)) {directionchange*=-1;}
	}
	//koniec
	
	public  void die() {
		//System.out.println("You lose");
		State.setState(handler.getGame().menuState);
		JFrame lose=new JFrame("lose");
		lose.setVisible(true);
		lose.setSize(300,300);
		lose.setLocation(900, 450);
		String finalstring;
		if(Collect.menu.SettingsView.name==null) {finalstring=("Your score:"+Collect.statics.Tree.score);}
		else {System.out.println(finalstring=Collect.menu.SettingsView.name+" your score is: "+Collect.statics.Tree.score);}
		JLabel labellose=new JLabel(finalstring);
		lose.add(labellose);
		
	};
	
	
	Random r = new Random(); 
	int randdirection = r.nextInt(2); 
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(randdirection==0) {xMove=-speed*directionchange*Collect.menu.SettingsView.level;}
		if(randdirection==1) {yMove=-speed*directionchange*Collect.menu.SettingsView.level;}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()) , (int) (y-handler.getGameCamera().getyOffset()), width, height, null); //wszystko odwzoruje funkcja drawImage
			
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
			return Assets.opponent_down[1];
		}
	}

	final static Random rand = new Random();
	

}

package Collect.states;

import java.awt.Graphics;

import Collect.Game;
import Collect.Handler;
import Collect.entities.Player;
import Collect.graphics.Assets;
import Collect.statics.Tree;
import Collect.tiles.Tile;
import Collect.tiles.World;

public class GameState extends State
{
	
	//private Player player;
	private World world;
	//private Tree tree;

	public GameState(Handler handler) 
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		//player = new Player(handler, 100, 100);	
		//tree = new Tree(handler, 250, 250, 32, 32);
		
	}
	
	@Override
	public void tick() 
	{
		world.tick();
		//player.tick(); //bardzo wa¿na linijka
		//game.getGameCamera().move(1, 1);
		//tree.tick();
		
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		//player.render(g);		//teraz gracz jest nad p³ytkami " tiles "
		//Tile.tiles[0].render(g, 0, 0);
		//tree.render(g);
		
	}
	
}
 
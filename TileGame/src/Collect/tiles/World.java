package Collect.tiles;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import Collect.Game;
import Collect.Handler;
import Collect.entities.EntityManager;
import Collect.entities.Opponent;
import Collect.entities.Player;
import Collect.statics.Tree;
import Collect.utils.Utils;
import Collect.entities.Player;

public class World 
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100), new Opponent(handler, 300, 300));
		entityManager.addEntity(new Tree(handler, 250, 250, 32, 32));
		entityManager.addEntity(new Opponent(handler, 300, 250));
		
		
		loadWorld(path);
	
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		entityManager.getOpponent().setX(350);
		entityManager.getOpponent().setY(300);
		
		Random r = new Random(); 
		int randdirection = r.nextInt(2);
		
		
		 Timer timerColor = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a  = r.nextInt(600);
				int b = r.nextInt(600);
				entityManager.addEntity(new Opponent(handler, a+100, b+100));
			}

		});
		 timerColor.start();
		
		
		
	}
	
	public void tick()
	{
		entityManager.tick();
		
		 
	}
	public void render (Graphics g)
	{
		//Optymalizacja, wczytywanie tylko tego co widzimy
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);;
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getWidth())/Tile.TILEHEIGHT+1);
		
		for(int y=yStart; y<yEnd ; y++)
		{
			for(int x=xStart; x<xEnd; x++)
			{
				getTile(x,y).render(g,  (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); // odcinek 19
			}
		}
		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y)
	{
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)							//gdy id jest poza wsystkimi dostêpnymi ustaw grasstile
			return Tile.dirtTile;  
		return t;
	}
	
	private void loadWorld(String path)
	{
		
		String file = Utils.loadFileAsString(path); //wczystywanie parapetrów gracza z pliku
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens [0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens [2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for( int x=0; x<width;x++)
		{
			for(int y=0; y<height; y++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]); //+4 bo powy¿sze width heaight i spawnx i spawny
			}
		}
		
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}

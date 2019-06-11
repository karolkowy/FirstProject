package Collect.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.Iterator;

import Collect.Handler;

public class EntityManager 
{
	
	private Handler handler;
	private Player player;
	private Opponent opponent;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>()
			{

				@Override
				public int compare(Entity a, Entity b) {
					if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
					{
						return -1;
					}
					return 1;
				}
		
			};
	
	public EntityManager(Handler handler, Player player, Opponent opponent)
	{
		this.handler= handler;
		this.player = player;
		this.opponent = opponent;
		
		entities = new ArrayList<Entity>();	
		addEntity(player);
		addEntity(opponent);
		
	}

	public void tick()
	{
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g)
	{
		for(int i=0; i<entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.render(g);
		}
		//player.render(g);
	}
	public void addEntity(Entity e)
	{
		entities.add(e);  
	}
	
	//metody set i get

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Opponent getOpponent() {
		return opponent;
	}

	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
}

package Collect;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Collect.display.Display;
import Collect.graphics.Assets;
import Collect.graphics.GameCamera;
import Collect.graphics.SpriteSheet;
import Collect.input.KeyManager;
import Collect.states.GameState;
import Collect.states.MenuState;
import Collect.states.State;

public class Game implements Runnable
{
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread; 
	
	private BufferStrategy bs; //zawiera instrukcje jak komputer ma cos rysowaæ
	private Graphics g;
	
	//private BufferedImage test;
	//private SpriteSheet sheet;
	
	//States
	public State gameState;
	public State menuState;
	
	 
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height  =height;
		this.title=title;
		keyManager = new KeyManager(); 
		
	}

	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); 
		Assets.init(); //za³aduje wszystkie obrazki jednorazowo itp.
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}

	
	
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3); //3 nie wiêcej
			return;
		}
		g = bs.getDrawGraphics();
		// wyczysc screena
		g.clearRect(0, 0, width, height);
		//rysuj
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		
		//koniec rysowania
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() 
	{
		
		init();
		
		 int fps = 60; //ile ticków na k¹¿d¹ sekundê, czyli klatek na sek
		 double timePerTick = 1000000000 / fps; 
		 double delta =0;
		 long now;
		 long lastTime = System.nanoTime();
		 long timer = 0;
		 int ticks = 0;
		
		while(running) //game loop
		{
			now = System.nanoTime(); 
			delta += (now - lastTime)/timePerTick; //dzieki temu komputer wie kiedy wywo³ywaæ pêtle
			timer += now - lastTime;
			lastTime=now;
			
			if(delta >= 1) 
			{
				tick(); //tick wszystko przelicza
				render(); //render wszystko narysuje
				ticks++;
				delta--;
			} 
			
			if(timer>= 1000000000)
			{
				//System.out.println("Ticks and frames: " +ticks);//pokazuje ile klatek co sekunde
				ticks =0;
				timer=0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public synchronized void start()
	{
		if(running)	
			return;	//jeœli ju¿ dzia³a to nic z tym nie rób
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

package Collect.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import Collect.entities.Creature;
import Collect.entities.Entity;

public class Display {

	private JFrame frame;
	private Canvas canvas; 
	
	private String title;
	
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
		
	}
	
	private void createDisplay() {
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false); 
		
		frame.add(canvas);
		frame.pack();
		
		JLabel label= new JLabel();
		frame.add(label);
		
		//if(Collect.entities.Entity.checkEntityCollisions(Collect.entities.Creature.getxMove(), 0f)) {System.out.println("blad");};
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;  //						UWAGA O co tu chodzi !!! odcinek 14 8:30
	}
	
	
	
}
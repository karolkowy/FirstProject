package Collect.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Collect.Game;


public class Menu extends JFrame implements ActionListener {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() throws HeadlessException {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.blue);
		
		setLayout(new BorderLayout());
	
		
		JPanel pleft = new JPanel();
		JPanel pright = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p5 = new JPanel();
		
		//menu
				JMenuBar menuBar = new JMenuBar();
				this.setJMenuBar(menuBar);
				
				JMenu m_minimalize = new JMenu("_");
				JMenu m_full_screen = new JMenu("Normal screen");
				JMenu m_exit = new JMenu("Exit");
				
				menuBar.add(m_minimalize);
				menuBar.add(m_full_screen);
				menuBar.add(m_exit);
				
				
				
				//small screen
				JMenuItem menuItem0 = new JMenuItem("Normal screen");
				m_full_screen.add(menuItem0);
				menuItem0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem0.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setSize(900,800);
						
					}
				});
				
				//exit 
				JMenuItem menuItem1 = new JMenuItem("Exit");
				m_exit.add(menuItem1);
				menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
				});
				
				//minimalize
				JMenuItem menuItem2 = new JMenuItem("Minimalize");
				m_minimalize.add(menuItem2);
				menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setExtendedState(JFrame.ICONIFIED);
						
					}
				});
	

		//p left
				
		ImageIcon obrazek_postac1 = new ImageIcon(getClass().getResource("CollectPostacStomil1.jpg"));
		
		JLabel etykieta1 = new JLabel();		
		etykieta1.setIcon(obrazek_postac1);
		pleft.add(etykieta1);
		pleft.setBackground(Color.blue);
		
		
		//p right
		ImageIcon obrazek_postac2 = new ImageIcon(getClass().getResource("CollectPostacLegia1.jpg"));
		JLabel etykieta2 = new JLabel();		
		etykieta2.setIcon(obrazek_postac2);
		pright.add(etykieta2);
		pright.setBackground(Color.blue);		
				
				
		//p2 probne
				JButton birdButton=new JButton ("Nowa gra");
				//birdButton.setBackground(Color.white);
				   JButton catButton=new JButton ("Tabela wynikow");
				ButtonGroup group = new ButtonGroup();  
				group.add(birdButton);
				group.add(catButton);
				
	
		
		//p3
		 p3.setLayout(new GridLayout(4,1));
		
		 ImageIcon obrazek_nowa_gra = new ImageIcon(getClass().getResource("nowa_graa.jpg"));
		 ImageIcon obrazek_tabela_wynikow = new ImageIcon(getClass().getResource("tabela_wynikow.jpg"));
		 ImageIcon obrazek_ustawienia = new ImageIcon(getClass().getResource("ustawienia.jpg"));
		 ImageIcon obrazek_wyjscie = new ImageIcon(getClass().getResource("wyjscie_z_gry.jpg"));
		  
		   JButton b_nowa_gra=new JButton (obrazek_nowa_gra);
		   JButton b_tabela_wynikow=new JButton (obrazek_tabela_wynikow);
		   JButton b_ustawienia=new JButton (obrazek_ustawienia);
		   JButton b_wyjscie_z_gry=new JButton (obrazek_wyjscie);
		   
		   b_nowa_gra.setSize(321, 173);
		   
		   p3.add(b_nowa_gra);
		   p3.add(b_tabela_wynikow);
		   p3.add(b_ustawienia);
		   p3.add(b_wyjscie_z_gry);
		   
		 //p5
		   JLabel l1_p1=new JLabel ("by Rokatoka Judoka, Szkocik");
		   JLabel l2_p2=new JLabel ("2019 all rights reserved");
		   
		   p5.add(l1_p1);
		   p5.add(l2_p2);
	
		   
		//dodawanie paneli
		  add(BorderLayout.EAST, pright);
		  add(BorderLayout.WEST, pleft);
		  add(BorderLayout.CENTER, p3);
		  add(BorderLayout.PAGE_END, p5);
		  
		//action listeners
		  
		//action listener nowa gra
		  ActionListener  b_nowa_gra_act_list = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Game game = new Game("Collect!", 890, 700);
					game.start();
				}
			};
			b_nowa_gra.addActionListener(b_nowa_gra_act_list);
		  
		//action listener tabela
		  ActionListener  b_tabela_wynikow_act_list = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Scores frame_tabela_wynikow= new Scores();
					frame_tabela_wynikow.setVisible(true);
				}
			};
			b_tabela_wynikow.addActionListener(b_tabela_wynikow_act_list);
	
	
		 
		//action listener ustawienia
		  ActionListener  b_ustawienia_act_list = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SettingsView frame_ustawienia= new SettingsView();
					frame_ustawienia.setVisible(true);
				}
			};
			b_ustawienia.addActionListener(b_ustawienia_act_list);
			
			//action listener wyjscie
			  ActionListener  b_wyjscie_act_list = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				};
				b_wyjscie_z_gry.addActionListener(b_wyjscie_act_list);
			
	
	}	
		
	public Menu(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Menu(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Menu(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	
	
	 public void actionPerformed(ActionEvent e)
	    {    
	      
	    }

	public static void main(String[] args) {
		Menu ramka= new Menu();
		ramka.setVisible(true);

	}

}

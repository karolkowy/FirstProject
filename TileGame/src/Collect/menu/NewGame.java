package Collect.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class NewGame extends JFrame implements ActionListener {

	public NewGame() throws HeadlessException {
		this.setSize(900,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.blue);

		JPanel p_nowa_gra = new JPanel();


		
		//menu
				JMenuBar menuBar = new JMenuBar();
				this.setJMenuBar(menuBar);
				
				JMenu m_minimalize = new JMenu("_");
				JMenu m_full_screen = new JMenu("Full screen");
				JMenu m_exit = new JMenu("Powrot do menu");
				
				menuBar.add(m_minimalize);
				menuBar.add(m_full_screen);
				menuBar.add(m_exit);
				
				
				
				//full screen
				JMenuItem menuItem0 = new JMenuItem("Full Screen");
				m_full_screen.add(menuItem0);
				menuItem0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem0.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setExtendedState(JFrame.MAXIMIZED_BOTH);
						
					}
				});
				
				
				JMenuItem menuItem1 = new JMenuItem("Powrot do menu");
				m_exit.add(menuItem1);
				menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
					}
				});
				
				
				//panel top 
				   JLabel l_nowa_gra=new JLabel ("TU BEDZIE NOWA GRA");
				   p_nowa_gra.add(l_nowa_gra);
				  
			//dodawanie paneli do ramki	 
				   
				   	   
					
					ImageIcon obrazek1 = new ImageIcon(getClass().getResource("screen_z_rozgrywki.JPG"));

					
			// Wyswietlanie pierwszego obrazka w etykiecie z tekstem				
					JLabel etykieta = new JLabel();		
					etykieta.setIcon(obrazek1);
					add(etykieta);
					
					add( etykieta);


				
	}

	public NewGame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public NewGame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public NewGame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	
	public static void main(String args[]) {
		new NewGame();
		//PRZYKLADY WCZYTYWANIA I WYSWIETLANIA OBRAZKOW Z PLIKOW
	}
}

package Collect.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class Scores extends JFrame implements ActionListener {

	public Scores() throws HeadlessException {
		this.setSize(900,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		setBackground(Color.blue);

		JPanel p_t_top = new JPanel();
		JPanel p_t_tablica = new JPanel();

		
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
				
				//exit, ale nie dziala jak trzeba :(
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
				   JLabel l_t_tablica=new JLabel ("TABLICA");
				   p_t_top.add(l_t_tablica);
				  
			//dodawanie paneli do ramki	 
				   add(p_t_top);
				   add(p_t_tablica);

				
	}


	public Scores(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Scores(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Scores(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

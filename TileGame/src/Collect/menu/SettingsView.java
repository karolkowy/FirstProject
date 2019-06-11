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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class SettingsView extends JFrame implements ActionListener {

	public static int postac = 0;
	public static int mapa = 0;
	public static String name;
	public static int level=1;
	
	public SettingsView() throws HeadlessException {
		this.setSize(900,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(5,1));
		setBackground(Color.blue);

		JPanel p_u_top = new JPanel();
		JPanel p_u_nazwauzytkowniaka = new JPanel();
		JPanel p_u_wybor_koloru = new JPanel();
		JPanel p_u_wybor_postaci = new JPanel();
		JPanel p_u_wybor_poziomu_trudnosci = new JPanel();
		
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
				
				//exit, w przyszlosci powrot do menu
				JMenuItem menuItem1 = new JMenuItem("Powrot do menu");
				m_exit.add(menuItem1);
				menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
				
				menuItem1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					setVisible(false);
						
					}
				});
				
				
			//dodawanie elementow
			
			// top panel
				p_u_top.add(new JLabel("USTAWIENIA"));
			
				
			//penel podawania nazwy
				JLabel l_u_nazwa=new JLabel ("Podaj swoja nazwe graczu");
				JTextField tfx_nazwa=new JTextField ("Pisz tutaj");
				JButton button_nazwa=new JButton ("Zapisz");
				
				p_u_nazwauzytkowniaka.add(l_u_nazwa);
				p_u_nazwauzytkowniaka.add(tfx_nazwa);
				p_u_nazwauzytkowniaka.add(button_nazwa);
				
				
				

				   
			//panel plansza
				   JLabel l_u_kolor=new JLabel ("Wybierz kolor tla");
				   ButtonGroup group_plansza = new ButtonGroup();
				   
				   JRadioButton przycisk_gorny=new JRadioButton ("Warszawa");
				   JRadioButton przycisk_srodkowy=new JRadioButton ("Olsztyn");
				   
				   przycisk_gorny.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						mapa = 0;
						
					}
				});
				   
				   przycisk_srodkowy.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						mapa = 1;
						
					}
				});
				   
				   group_plansza.add(przycisk_gorny);
				   group_plansza.add(przycisk_srodkowy);
				   	   
				   p_u_wybor_koloru.add(l_u_kolor);
				   p_u_wybor_koloru.add(przycisk_gorny);
				   p_u_wybor_koloru.add(przycisk_srodkowy);
				   
			
			//panel postac
				   JLabel l_u_postac=new JLabel ("Wybierz postac");
				   ImageIcon obrazek_postac1 = new ImageIcon(getClass().getResource("CollectPostacStomil1.jpg"));
				   ImageIcon obrazek_postac1_wyb = new ImageIcon(getClass().getResource("CollectPostacStomil1wyb.jpg"));
				   ImageIcon obrazek_postac2 = new ImageIcon(getClass().getResource("CollectPostacLegia1.jpg"));
				   ImageIcon obrazek_postac2_wyb = new ImageIcon(getClass().getResource("CollectPostacLegia1wyb.jpg"));
				   JRadioButton przycisk1_postac=new JRadioButton (obrazek_postac1);
				   JRadioButton przycisk2_postac=new JRadioButton (obrazek_postac2);
				   
				   przycisk1_postac.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//setIconImage(getClass().getResource("CollectPostacLegia1.jpg"));
						przycisk1_postac.setIcon(obrazek_postac1_wyb);
						przycisk2_postac.setIcon(obrazek_postac2);
						
						//setK(1);
						postac=0;
						
						//System.out.println("Postac 1 " + getK()); 
					}
				});
				   
				   przycisk2_postac.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						przycisk2_postac.setIcon(obrazek_postac2_wyb);
						przycisk1_postac.setIcon(obrazek_postac1);
						
						postac=1; 
						
					}
				});
				   
				   
				   p_u_wybor_postaci.add(l_u_postac);
				   p_u_wybor_postaci.add(przycisk1_postac);
				   p_u_wybor_postaci.add(przycisk2_postac);

				 //panel trudnosc
				   JLabel l_u_poziom=new JLabel ("Wybierz poziom trudnosci");
				   ButtonGroup group_poziom  = new ButtonGroup();  
				   JRadioButton przycisk1_poziom=new JRadioButton ("£atwy");
				   JRadioButton przycisk2_poziom=new JRadioButton ("Œredni");
				   JRadioButton przycisk3_poziom=new JRadioButton ("Trudny");
				   group_poziom.add(przycisk1_poziom);
				   group_poziom.add(przycisk2_poziom);
				   group_poziom.add(przycisk3_poziom);
				   
				   
				   p_u_wybor_poziomu_trudnosci.add(l_u_poziom);
				   p_u_wybor_poziomu_trudnosci.add(przycisk1_poziom);
				   p_u_wybor_poziomu_trudnosci.add(przycisk2_poziom);
				   p_u_wybor_poziomu_trudnosci.add(przycisk3_poziom); 
				  
			//dodawanie paneli do ramki	 
				   add(p_u_top);
				   add(p_u_nazwauzytkowniaka);
				   add(p_u_wybor_koloru);
				   add(p_u_wybor_postaci);
				   add(p_u_wybor_poziomu_trudnosci);
				   
				   
			
				   //bg color
				   ActionListener button_nazwa_buttonListener = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							name= tfx_nazwa.getText();
							
						}
					};
					button_nazwa.addActionListener(button_nazwa_buttonListener);
					
					//action listener bpomarancz
					przycisk1_poziom.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            level=1;
				        }
				    });	//action listener bpomarancz
					przycisk2_poziom.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            level=2;
				        }
				    });
					
					//action listener bpomarancz
					przycisk3_poziom.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            level=3;
				        }
				    });
					
					
	}

	public SettingsView(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public SettingsView(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public SettingsView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	
	
}

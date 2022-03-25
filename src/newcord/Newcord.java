package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Newcord extends JFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Newcord
	public static Newcord newcord;
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		newcord = new Newcord();
	}

	private int posX = 0, posY = 0;
	
	Newcord() {
		// Frame
		setSize(2560, 1440);
		setUndecorated(true);
		setMinimumSize(new Dimension(1880, 1000));
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)screenDim.getWidth()/2-getWidth()/2, (int)screenDim.getHeight()/2-getHeight()/2);
		
		// Entire view
		JPanel viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBackground(new Color(32, 34, 37));
		viewPanel.setSize(getWidth(), 50);
		
		viewPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				posX = e.getX();
				posY = e.getY();
			}
		});

		viewPanel.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){		
				setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);		
			}
		});
		
		getContentPane().add(viewPanel);
		
		// Logo
		JLabel logoLabel = new JLabel("Newcord");
		logoLabel.setLocation(18, 10);
		logoLabel.setSize(130, 30);
		logoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		logoLabel.setForeground(new Color(114, 118, 125));
		
		viewPanel.add(logoLabel);

		// Window buttons
		Font windowButtonFont = new Font(null, Font.PLAIN, 29);
		
		JLabel closeButton = new JLabel("✕", SwingConstants.CENTER);
		closeButton.setFont(windowButtonFont);
		closeButton.setSize(62, 50);
		closeButton.setOpaque(true);
		closeButton.setLocation(getWidth()-closeButton.getWidth(), 0);
		closeButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_CLOSE, 
				new Color(237, 66, 69), 
				new Color(255, 255, 255), 
				new Color(237, 66, 69), 
				new Color(255, 255, 255), 
				new Color(32, 34, 37), 
				new Color(185, 187, 190)));
		closeButton.setBackground(new Color(32, 34, 37));
		closeButton.setForeground(new Color(159, 161, 165));
		
		JLabel fullscreenButton = new JLabel("□", SwingConstants.CENTER);
		fullscreenButton.setFont(windowButtonFont);
		fullscreenButton.setSize(62, 50);
		fullscreenButton.setOpaque(true);
		fullscreenButton.setLocation(closeButton.getX()-fullscreenButton.getWidth(), 0);
		fullscreenButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_FULLSCREEN, 
				new Color(40, 43, 46), 
				new Color(190, 191, 193), 
				new Color(43, 46, 50), 
				new Color(220, 220, 221), 
				new Color(32, 34, 37), 
				new Color(160, 162, 164)));
		fullscreenButton.setBackground(new Color(32, 34, 37));
		fullscreenButton.setForeground(new Color(159, 161, 165));
		
		JLabel minimizeButton = new JLabel("—", SwingConstants.CENTER);
		minimizeButton.setFont(windowButtonFont);		
		minimizeButton.setSize(62, 50);
		minimizeButton.setOpaque(true);
		minimizeButton.setLocation(fullscreenButton.getX()-minimizeButton.getWidth(), 0);
		minimizeButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_FULLSCREEN, 
				new Color(40, 43, 46), 
				new Color(190, 191, 193), 
				new Color(43, 46, 50), 
				new Color(220, 220, 221), 
				new Color(32, 34, 37), 
				new Color(160, 162, 164)));
		minimizeButton.setBackground(new Color(32, 34, 37));
		minimizeButton.setForeground(new Color(159, 161, 165));
		
		viewPanel.add(fullscreenButton);
		viewPanel.add(closeButton);
		viewPanel.add(minimizeButton);

		// Server list panel
		JPanel serverPanel = new JPanel();
		serverPanel.setBackground(viewPanel.getBackground());
		
		JScrollPane serverScrollPane = new JScrollPane(serverPanel);
		serverScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		serverScrollPane.setLocation(30, 50);
		serverScrollPane.setSize(106, getHeight()-50);
		serverScrollPane.setOpaque(true);
		serverScrollPane.setBorder(null);

		//GridLayout grid = new GridLayout(0, 1, 0, 10);
		//serverPanel.setLayout(grid);
		serverPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		HomeProfile dmProfile = new HomeProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 10, 0);
		serverPanel.add(dmProfile, gbc);
		
		JLabel splitLabel = new JLabel("————", SwingConstants.CENTER);
		splitLabel.setPreferredSize(new Dimension(106, 20));
		splitLabel.setForeground(new Color(85, 87, 90));
		splitLabel.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 20, 0);
		serverPanel.add(splitLabel, gbc);
		
		LinkedList<ServerProfile>serverProfiles = new LinkedList<ServerProfile>();
		int i = 2;
		while(i < 12) {
			ServerProfile sp = new ServerProfile(new ImageIcon("src/resources/testicon.png").getImage(), "ID");
			serverProfiles.add(sp);
			gbc.gridx = 0;
			gbc.gridy = i;
			serverPanel.add(sp, gbc);
			i++;
		}
		i++;
		
		AddServerProfile addServerProfile = new AddServerProfile();
		gbc.gridx = 0;
		gbc.gridy = i+1;
		serverPanel.add(addServerProfile, gbc);
		
		ExploreProfile exploreProfile = new ExploreProfile();
		gbc.gridx = 0;
		gbc.gridy = i+2;
		gbc.insets = new Insets(0, 0, 30, 0);
		serverPanel.add(exploreProfile, gbc);
		
		viewPanel.add(serverScrollPane);
		
		// Friend list panel
		JScrollPane friendsScrollPane = new JScrollPane();
		friendsScrollPane.getVerticalScrollBar().setUI(new ScrollBar());

		// Channel list panel
		JScrollPane channelScrollPane = new JScrollPane();
		channelScrollPane.getVerticalScrollBar().setUI(new ScrollBar());


		setVisible(true);
	}
}

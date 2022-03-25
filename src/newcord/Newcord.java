package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JSeparator;
import javax.swing.JViewport;
import javax.swing.SwingConstants;

public class Newcord extends JFrame {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		new Newcord();
	}

	private int posX = 0, posY = 0;

	Newcord() {
		setSize(2560, 1440);
		setMinimumSize(new Dimension(1880, 1000));

		JPanel viewPanel = new JPanel();

		JLabel logoLabel = new JLabel("Newcord");
		logoLabel.setLocation(18, 10);
		logoLabel.setSize(130, 30);
		logoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		logoLabel.setForeground(new Color(114, 118, 125));

		JLabel closeButton = new JLabel("x");
		JLabel fullscreenButton = new JLabel("");
		JLabel minimizeButton = new JLabel();

		viewPanel.setLayout(null);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)screenDim.getWidth()/2-getWidth()/2, (int)screenDim.getHeight()/2-getHeight()/2);
		setUndecorated(true);
		getContentPane().add(viewPanel);
		viewPanel.setBackground(new Color(32, 34, 37));

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
		viewPanel.setBackground(new Color(32, 34, 37));
		viewPanel.setSize(getWidth(), 50);

		JPanel serverPanel = new JPanel();
		JScrollPane serverScrollPane = new JScrollPane(serverPanel);
		serverScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
		serverScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		serverScrollPane.setLocation(29, 50);
		serverScrollPane.setSize(106, getHeight()-50);
		serverScrollPane.setOpaque(true);
		serverScrollPane.setBorder(null);
		serverPanel.setBackground(viewPanel.getBackground());

		//GridLayout grid = new GridLayout(0, 1, 0, 10);
		//serverPanel.setLayout(grid);
		serverPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 20, 0);
		JPanel homePanel = new JPanel();
		HomeProfile dmProfile = new HomeProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		serverPanel.add(dmProfile, gbc);
		//JSeparator sep = new JSeparator();
		//sep.setBackground(new Color(255, 255, 255));
		JLabel splitLabel = new JLabel("——————", SwingConstants.CENTER);
		splitLabel.setPreferredSize(new Dimension(106, 20));
		splitLabel.setForeground(new Color(85, 87, 90));
		//splitLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		serverPanel.add(splitLabel, gbc);
		LinkedList<ServerProfile>serverProfiles = new LinkedList<ServerProfile>();
		for(int i = 0; i < 100; i++) {
			ServerProfile sp = new ServerProfile(new ImageIcon("servericon").getImage(), "ID");
			serverProfiles.add(sp);
			gbc.gridx = 0;
			gbc.gridy = 2+i*2;
			serverPanel.add(sp, gbc);
		}

		JScrollPane friendsScrollPane = new JScrollPane();
		friendsScrollPane.getVerticalScrollBar().setUI(new ScrollBar());

		JScrollPane channelScrollPane = new JScrollPane();
		channelScrollPane.getVerticalScrollBar().setUI(new ScrollBar());

		viewPanel.add(logoLabel);
		viewPanel.add(serverScrollPane);

		setVisible(true);
	}
}

package newcord;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Newcord {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		new Newcord();
	}

	private int posX = 0, posY = 0;
	
	static JFrame frame;
	static JPanel viewPanel;
	
	Newcord() {
		frame = new JFrame("Newcord");
		viewPanel = new JPanel();
		// Frame
		frame.setSize(2560, 1440);
		frame.setUndecorated(true);
		frame.setMinimumSize(new Dimension(1880, 1000));
		frame.setBackground(new Color(32, 34, 37));

		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)screenDim.getWidth()/2-frame.getWidth()/2, (int)screenDim.getHeight()/2-frame.getHeight()/2);
		
		// Entire view
		viewPanel.setLayout(null);
		viewPanel.setBackground(new Color(32, 34, 37));
		viewPanel.setSize(frame.getWidth(), 50);
		viewPanel.setLayout(null);
		
		viewPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				posX = e.getX();
				posY = e.getY();
			}
		});

		viewPanel.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){		
				frame.setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);		
			}
		});
		
		frame.getContentPane().add(viewPanel);
		
		// Logo
		JLabel logoLabel = new JLabel("Newcord");
		logoLabel.setLocation(18, 10);
		logoLabel.setSize(130, 30);
		logoLabel.setFont(new Font("Whitney", Font.BOLD, 30));
		logoLabel.setForeground(new Color(114, 118, 125));
		
		viewPanel.add(logoLabel);

		// Window buttons
		Font windowButtonFont = new Font(null, Font.PLAIN, 29);
		
		JLabel closeButton = new JLabel("✕", SwingConstants.CENTER);
		closeButton.setFont(windowButtonFont);
		closeButton.setSize(62, 50);
		closeButton.setOpaque(true);
		closeButton.setLocation(frame.getWidth()-closeButton.getWidth(), 0);
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
				WindowButtonListener.FRAME_MINIMIZE, 
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
		
		viewPanel.add(new ServerList());
		viewPanel.add(new ChannelList());
		
		for(Component i : viewPanel.getComponents())
			System.out.println(i.getName());
		
		// Friend list panel
		JScrollPane friendsScrollPane = new JScrollPane();
		friendsScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(47, 49, 54), new Color(32, 34, 37), true));

		// Channel list panel
		JScrollPane channelScrollPane = new JScrollPane();
		channelScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(47, 49, 54), new Color(32, 34, 37), true));

		frame.setVisible(true);
		
	}
}

package newcord;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Newcord {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		new Newcord();
	}

	private int posX = 0, posY = 0;
	private final ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/icon.png"));
	
	static JFrame frame;
	static JPanel viewPanel;
	
	Newcord() {
		frame = new JFrame("Newcord");
		viewPanel = new JPanel();
		// Frame
		frame.setSize(2560, 1440);
		frame.setUndecorated(true);
		frame.setIconImage(icon.getImage());
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
		logoLabel.setName("NewcordLabel");
		logoLabel.setLocation(18, 10);
		logoLabel.setSize(130, 30);
		logoLabel.setFont(new Font("Whitney", Font.BOLD, 30));
		logoLabel.setForeground(new Color(114, 118, 125));
		
		viewPanel.add(logoLabel);

		viewPanel.add(new WindowButtons());
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

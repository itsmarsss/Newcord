package newcord;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Newcord {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1");
		new Newcord();
	}
	
	// Frame dragging
	private int posX = 0, posY = 0;
	private boolean drag = false;

	static JFrame frame;
	static JPanel viewPanel;

	Newcord() {
		// Init
		frame = new JFrame("Newcord");
		viewPanel = new JPanel();
		
		// Frame
			// Frame Icon
		List<Image>icons = new ArrayList<Image>();
		icons.add(new ImageIcon("src/resources/Icon1.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon2.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon3.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon4.png").getImage());
		frame.setIconImages((List<? extends Image>)icons);
		
			// Frame Init
		frame.setUndecorated(true);
		frame.setBackground(new Color(32, 34, 37));
		frame.setMinimumSize(new Dimension(1880, 1000));
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize((int)screenDim.getWidth()/2, (int)screenDim.getHeight()/2);
		frame.setLocation((int)screenDim.getWidth()/2-frame.getWidth()/2, (int)screenDim.getHeight()/2-frame.getHeight()/2);

		// Entire View
		
			// View Init
		viewPanel.setLayout(null);
		viewPanel.setSize(frame.getWidth(), 50);
		viewPanel.setBackground(new Color(32, 34, 37));
		
			// Drag 'n' Drop
		viewPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getY() < 50) {
					drag = true;
					posX = e.getX();
					posY = e.getY();
				}else {
					drag = false;
				}
			}
		});
		viewPanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(drag)
					frame.setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);		
			}
		});

		frame.getContentPane().add(viewPanel);

		// Logo
		JLabel logoLabel = new JLabel("Newcord");
		logoLabel.setName("NewcordLabel");
		logoLabel.setSize(130, 30);
		logoLabel.setLocation(18, 10);
		logoLabel.setForeground(new Color(114, 118, 125));
		logoLabel.setFont(new Font("Whitney", Font.BOLD, 28));

		viewPanel.add(logoLabel);

		// Add Other Components
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

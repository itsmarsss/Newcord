package newcord;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import newcord.components.ChannelList;
import newcord.components.ServerList;
import newcord.components.WindowButtons;
import newcord.newui.ScrollBarUI;

public class Newcord {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1");
		new Newcord();
	}

	// Frame dragging
	private int posX = 0, posY = 0;
	private boolean drag = false;

	// Resize
	public static int oldW;
	public static int oldH;
	public static int oldX;
	public static int oldY;
	public static boolean full = false;

	public static JFrame frame;
	public static JPanel viewPanel;
	public static WindowButtons windowButtons;
	public static ServerList serverList;
	public static ChannelList channelList;

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
		frame.getContentPane().setLayout(null);
		frame.setMinimumSize(new Dimension(1880, 1000));
		frame.getContentPane().setBackground(new Color(32, 34, 37));
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize((int)screenDim.getWidth()/2, (int)screenDim.getHeight()/2);
		frame.setLocation((int)screenDim.getWidth()/2-frame.getWidth()/2, (int)screenDim.getHeight()/2-frame.getHeight()/2);

		// Entire View

		// View Init
		ComponentResizer cr = new ComponentResizer();
		cr.registerComponent(frame);
		cr.setSnapSize(new Dimension(1, 1));
		cr.setMinimumSize(new Dimension(1880, 1000));
		cr.setMaximumSize(screenDim);

		viewPanel.setLayout(null);
		viewPanel.setLocation(5, 5);
		viewPanel.setBackground(new Color(32, 34, 37));
		viewPanel.setSize(frame.getWidth()-10, frame.getHeight()-10);

		// Drag 'n' Drop
		viewPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getY() < 50 && e.getY() > 10) {
					drag = true;
					posX = e.getX();
					posY = e.getY();
				}else {
					drag = false;
				}
			}
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					if(full) {
						frame.setSize(oldW, oldH);
						frame.setLocation(oldX, oldY);
						full = false;
					}else {
						oldW = frame.getWidth();
						oldH = frame.getHeight();
						oldX = frame.getX();
						oldY = frame.getY();
						frame.setExtendedState(Frame.MAXIMIZED_BOTH);
						full = true;
					}
					resize();
					windowButtons.resize();
					serverList.resize();
					channelList.resize();
				} 
			}
		});
		viewPanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(drag) {
					frame.setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);
				}
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
		windowButtons = new WindowButtons();
		serverList = new ServerList();
		channelList = new ChannelList();

		viewPanel.add(windowButtons);
		viewPanel.add(serverList);
		viewPanel.add(channelList);

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

	public static void resize() {
		viewPanel.setLocation(5, 5);
		viewPanel.setSize(frame.getWidth()-10, frame.getHeight()-10);
	}
}

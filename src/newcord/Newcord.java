package newcord;

// Imports
// AWT
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

// Swing
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// Components
import newcord.components.ChannelList;
import newcord.components.ChatBoxArea;
import newcord.components.ServerList;
import newcord.components.WindowButtons;
import newcord.newui.ScrollBarUI;
import newcord.profiles.MessageProfile;

// Newcord Class
public class Newcord {
	// Main Function
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1");
		new Newcord();
	}

	// Frame dragging
	private int posX = 0, posY = 0;
	private boolean drag = false;

	// Non-fullscreen dimensions and toggle
	private static int oldW;
	private static int oldH;
	private static int oldX;
	private static int oldY;
	private static boolean full = false;

	// Main frame and components
	private static JFrame frame;					// Window holding everything
	private static JPanel viewPanel;
	private static WindowButtons windowButtons;		// Other components...
	private static ServerList serverList;
	private static ChannelList channelList;
	private static ChatBoxArea chatBoxArea;

	// Newcord Default Constructor
	Newcord() {
		// Init
		frame = new JFrame("Newcord");
		viewPanel = new JPanel();
		drawUI();
	}

	// render frame and viewPanel
	private void drawUI() {
		// Frame Icon
		List<Image>icons = new ArrayList<Image>();
		icons.add(new ImageIcon("src/resources/Icon1.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon2.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon3.png").getImage());
		icons.add(new ImageIcon("src/resources/Icon4.png").getImage());
		frame.setIconImages(icons);

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
				} else {
					drag = false;
				}
			}
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					doFullscreen();
				} 
			}
		});
		viewPanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(drag) {
					if(full) {
						frame.setSize(oldW, oldH);
						frame.setLocation(oldX, oldY);
						full = false;
						resize();
					}
					frame.setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);
				}
			}
		});

		frame.getContentPane().add(viewPanel);

		// Logo
		JLabel logoLabel = new JLabel("Newcord");
		logoLabel.setName("NewcordLogo");
		logoLabel.setSize(130, 30);
		logoLabel.setLocation(18, 10);
		logoLabel.setForeground(new Color(114, 118, 125));
		logoLabel.setFont(new Font("Whitney", Font.BOLD, 28));

		viewPanel.add(logoLabel);

		// Add Other Components
		windowButtons = new WindowButtons();
		serverList = new ServerList();
		channelList = new ChannelList();
		chatBoxArea = new ChatBoxArea();

		viewPanel.add(windowButtons);
		viewPanel.add(serverList);
		viewPanel.add(channelList);
		viewPanel.add(chatBoxArea);

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

	public static void doFullscreen() {
		if(full) {
			frame.setSize(oldW, oldH);
			frame.setLocation(oldX, oldY);
			full = false;
		} else {
			oldW = frame.getWidth();
			oldH = frame.getHeight();
			oldX = frame.getX();
			oldY = frame.getY();
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			full = true;
		}
		resize();
	}

	public static void resize() {
		viewPanel.setLocation(5, 5);
		viewPanel.setSize(frame.getWidth()-10, frame.getHeight()-10);

		windowButtons.setLocation(Newcord.viewPanel.getWidth()-186, 0);

		serverList.setSize(serverList.getWidth(), Newcord.viewPanel.getHeight()-50);

		channelList.setSize(channelList.getWidth(), Newcord.viewPanel.getHeight()-50);
		channelList.getChannelScrollPane().setSize(477, channelList.getHeight()-110);

		chatBoxArea.setSize(Newcord.getViewPanel().getWidth()-646, Newcord.getViewPanel().getHeight()-50);
		chatBoxArea.getChatBoxTopBarPanel().setSize(chatBoxArea.getWidth(), 106);
		chatBoxArea.getChatBoxScrollPane().setSize(chatBoxArea.getWidth()-395, chatBoxArea.getHeight()-106);
		chatBoxArea.getMembersScrollPane().setSize(395, chatBoxArea.getHeight()-106);
		chatBoxArea.getMembersScrollPane().setLocation(chatBoxArea.getChatBoxScrollPane().getWidth()+5, 106);
		for(MessageProfile mp : chatBoxArea.getMessageProfiles()) {
			mp.setPreferredSize(new Dimension(Newcord.getViewPanel().getWidth()-646, 100));
		}
	}

	public static JPanel getViewPanel() {
		return viewPanel;
	}

	public static JFrame getFrame() {
		return frame;
	}
}

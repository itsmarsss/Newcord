package newcord.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import newcord.Newcord;
import newcord.ResourceLoader;
import newcord.newui.ScrollBarUI;
import newcord.profiles.MessageProfile;

public class ChatBoxArea extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel chatBoxTopBarPanel;
	private JScrollPane chatBoxScrollPane;
	private JScrollPane membersScrollPane;
	public ChatBoxArea() {
		// Init
		setName("ChatBoxArea");
		
		setOpaque(true);
		setBorder(null);
		setLayout(null);
		setLocation(646, 50);
		setBackground(new Color(54, 57, 63));
		setSize(Newcord.getViewPanel().getWidth()-646, Newcord.getViewPanel().getHeight()-50);
		
		// Chat TopBar
		chatBoxTopBarPanel = new JPanel();
			// Chat Topbar Init
		chatBoxTopBarPanel.setLayout(null);
		chatBoxTopBarPanel.setSize(getWidth(), 106);
		chatBoxTopBarPanel.setBackground(new Color(54, 57, 63));
		chatBoxTopBarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(39,40,45)));
		
		add(chatBoxTopBarPanel);
		
		// Chat Section
		JPanel chatPanel = new JPanel();
		chatBoxScrollPane = new JScrollPane(chatPanel);
		chatPanel.setBackground(new Color(54, 57, 63));
		
			// Chat Init
		chatBoxScrollPane.setOpaque(true);
		chatBoxScrollPane.setBorder(null);
		chatBoxScrollPane.setLocation(0, 106);
		chatBoxScrollPane.setSize(1000, getHeight()-106);
		chatBoxScrollPane.setBackground(new Color(54, 57, 63));
		chatBoxScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		chatBoxScrollPane.getVerticalScrollBar().setBackground(getBackground());
		chatBoxScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
		chatBoxScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		chatBoxScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(46, 51, 56), new Color(32, 34, 37), true));
		
		add(chatBoxScrollPane);
		
		// Add Messages
		chatPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
			// Messages
		gbc.insets = new Insets(0, 0, 12, 5);
		LinkedList<MessageProfile>messageProfiles = new LinkedList<MessageProfile>();
		int i = 0;
		while(i < 100) {
			MessageProfile mp = new MessageProfile(ResourceLoader.loader.getTempProfileIcon().getImage(), "UserID", "MessageID");
			messageProfiles.add(mp);
			gbc.gridx = 0;
			gbc.gridy = i;
			chatPanel.add(mp, gbc);
			i++;
		}
	}
	public JPanel getChatBoxTopBarPanel() {
		return chatBoxTopBarPanel;
	}
	public JScrollPane getChatBoxScrollPane() {
		return chatBoxScrollPane;
	}
	public JScrollPane getMembersScrollPane() {
		return membersScrollPane;
	}
}

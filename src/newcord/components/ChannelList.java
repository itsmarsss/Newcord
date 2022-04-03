package newcord.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import newcord.Newcord;
import newcord.ResourceLoader;
import newcord.newui.ScrollBarUI;
import newcord.profiles.ChannelProfile;
import newcord.profiles.FriendProfile;

public class ChannelList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane channelScrollPane;
	public ChannelList() {
		// Init
		setName("ChannelList");
		
		setOpaque(true);
		setBorder(null);
		setLayout(null);		
		setLocation(166, 50);
		setBackground(new Color(47, 49, 54));
		setSize(480, Newcord.getViewPanel().getHeight()-50);

		// Channel TopBar
		JPanel channelTopBarPanel = new JPanel();
			// Channel TopBar Init
		channelTopBarPanel.setLayout(null);
		channelTopBarPanel.setSize(480, 106);
		channelTopBarPanel.setBackground(new Color(47, 49, 54));
		channelTopBarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(39,40,45)));
		
		add(channelTopBarPanel);
		
		// Channel Section
		JPanel channelPanel = new JPanel();
		channelScrollPane = new JScrollPane(channelPanel);
		channelPanel.setBackground(new Color(47, 49, 54));
		
			// Channel Init
		channelScrollPane.setOpaque(true);
		channelScrollPane.setBorder(null);
		channelScrollPane.setLocation(0, 106);
		channelScrollPane.setSize(477, getHeight()-110);
		channelScrollPane.setBackground(new Color(47, 49, 54));
		channelScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		channelScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		channelScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		channelScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(47, 49, 54), new Color(32, 34, 37), false));

		// Search
		JLabel searchLabel = new JLabel("  Find or start a conversation");
		
			// Search Init
		searchLabel.setOpaque(true);
		searchLabel.setSize(440, 56);
		searchLabel.setLocation(20, 25);
		searchLabel.setBackground(new Color(32, 34, 37));
		searchLabel.setForeground(new Color(114, 118, 125));
		searchLabel.setFont(new Font("Whitney", Font.PLAIN, 25));
		
		channelTopBarPanel.add(searchLabel);
		
		// Add Channels
		
			// Set Layout
		channelPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
			// Friend Profile
		FriendProfile friendProfile = new FriendProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 10, 1);
		
		channelPanel.add(friendProfile, gbc);
		
			// Splitter
		JLabel splitLabel = new JLabel("DIRECT MESSAGES                  ➕");
		splitLabel.setForeground(new Color(142, 146, 151));
		splitLabel.setPreferredSize(new Dimension(420, 25));
		splitLabel.setFont(new Font("Whitney", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 10, 1);
		
		channelPanel.add(splitLabel, gbc);
		
			// Channels
		LinkedList<ChannelProfile>channelProfiles = new LinkedList<ChannelProfile>();
		int i = 2;

		gbc.insets = new Insets(0, 10, 3, 1);
		while(i < 32) {
			ChannelProfile cp = new ChannelProfile(ResourceLoader.loader.getTempProfileIcon().getImage(), "ID");
			channelProfiles.add(cp);
			gbc.gridx = 0;
			gbc.gridy = i;
			if(i == 31) {
				gbc.insets = new Insets(0, 10, 10, 1);
			}
			channelPanel.add(cp, gbc);
			i++;
		}

		add(channelScrollPane);
	}
	public JScrollPane getChannelScrollPane() {
		return channelScrollPane;
	}
}

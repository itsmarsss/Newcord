package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChannelList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChannelList() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setName("ChannelsList");		
		setLocation(166, 50);
		setBackground(new Color(47, 49, 54));
		setSize(480, Newcord.frame.getHeight()-50);
		setOpaque(true);
		setBorder(null);
		setLayout(null);

		JPanel channelPanel = new JPanel();
		JScrollPane serverScrollPane = new JScrollPane(channelPanel);
		channelPanel.setBackground(new Color(47, 49, 54));
		serverScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
		serverScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(47, 49, 54), new Color(32, 34, 37), false));
		serverScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		serverScrollPane.setSize(477, getHeight()-106);
		serverScrollPane.setLocation(0, 106);
		serverScrollPane.setBackground(new Color(47, 49, 54));
		serverScrollPane.setOpaque(true);
		serverScrollPane.setBorder(null);

		JPanel channelTopBarPanel = new JPanel();
		channelTopBarPanel.setSize(480, 106);
		channelTopBarPanel.setBackground(new Color(47, 49, 54));
		channelTopBarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(39,40,45)));
		channelTopBarPanel.setLayout(null);
		add(channelTopBarPanel);

		JLabel searchLabel = new JLabel("  Find or start a conversation");
		searchLabel.setSize(440, 56);
		searchLabel.setOpaque(true);
		searchLabel.setBackground(new Color(32, 34, 37));
		searchLabel.setForeground(new Color(114, 118, 125));
		searchLabel.setLocation(20, 25);
		searchLabel.setFont(new Font("Whitney", Font.PLAIN, 25));
		channelTopBarPanel.add(searchLabel);
		
		channelPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		FriendProfile friendProfile = new FriendProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 10, 1);
		channelPanel.add(friendProfile, gbc);
		
		JLabel splitLabel = new JLabel("DIRECT MESSAGES                        +");
		splitLabel.setForeground(new Color(142, 146, 151));
		splitLabel.setFont(new Font("Whitney", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 3, 1);
		channelPanel.add(splitLabel, gbc);
		
		LinkedList<ChannelProfile>channelProfiles = new LinkedList<ChannelProfile>();
		int i = 2;
		while(i < 32) {
			ChannelProfile cp = new ChannelProfile(new ImageIcon("src/resources/testicon.png").getImage(), "ID");
			channelProfiles.add(cp);
			gbc.gridx = 0;
			gbc.gridy = i;
			if(i == 31)
				gbc.insets = new Insets(0, 10, 10, 1);
			channelPanel.add(cp, gbc);
			i++;
		}

		add(serverScrollPane);
	}
}
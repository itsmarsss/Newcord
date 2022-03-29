package newcord.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import newcord.Newcord;
import newcord.ResourceLoader;
import newcord.profiles.AddServerProfile;
import newcord.profiles.ExploreProfile;
import newcord.profiles.HomeProfile;
import newcord.profiles.ServerProfile;

public class ServerList extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerList() {
		// Init
		setName("ServerList");
		
		setOpaque(true);
		setBorder(null);
		setLocation(30, 50);
		setSize(106, Newcord.frame.getHeight()-50);
		getVerticalScrollBar().setUnitIncrement(15);
		getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

		// Server Section
		JPanel serverPanel = new JPanel();
		setViewportView(serverPanel);
		
			// Server Init
		serverPanel.setBackground(new Color(32, 34, 37));

		// Set Layout
		serverPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Add Servers
		
			// Home Profile
		HomeProfile dmProfile = new HomeProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 10, 0);
		
		serverPanel.add(dmProfile, gbc);

			// Splitter
		JLabel splitLabel = new JLabel("————", SwingConstants.CENTER);
		splitLabel.setForeground(new Color(85, 87, 90));
		splitLabel.setPreferredSize(new Dimension(106, 20));
		splitLabel.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 20, 0);
		
		serverPanel.add(splitLabel, gbc);
		
			// Servers
		LinkedList<ServerProfile>serverProfiles = new LinkedList<ServerProfile>();
		int i = 2;
		while(i < 12) {
			ServerProfile sp = new ServerProfile(ResourceLoader.loader.getTempProfileIcon().getImage(), "ID");
			serverProfiles.add(sp);
			gbc.gridx = 0;
			gbc.gridy = i;
			serverPanel.add(sp, gbc);
			i++;
		}
		i++;
		
			// Add Profile
		AddServerProfile addServerProfile = new AddServerProfile();
		gbc.gridx = 0;
		gbc.gridy = i+1;
		
		serverPanel.add(addServerProfile, gbc);
		
			// Explore Profile
		ExploreProfile exploreProfile = new ExploreProfile();
		gbc.gridx = 0;
		gbc.gridy = i+2;
		gbc.insets = new Insets(0, 0, 30, 0);
		
		serverPanel.add(exploreProfile, gbc);
	}
}

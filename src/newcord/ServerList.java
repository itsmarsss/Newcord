package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ServerList {
	public void add() {
		// Server list panel
		System.setProperty("sun.java2d.uiScale", "1.0");
		JPanel serverPanel = new JPanel();
		JScrollPane serverScrollPane = new JScrollPane(serverPanel);
		serverPanel.setBackground(new Color(32, 34, 37));
		serverScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		serverScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		serverScrollPane.setLocation(30, 50);
		serverScrollPane.setSize(106, Newcord.frame.getHeight()-50);
		serverScrollPane.setOpaque(true);
		serverScrollPane.setBorder(null);

		//GridLayout grid = new GridLayout(0, 1, 0, 10);
		//serverPanel.setLayout(grid);
		serverPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		HomeProfile dmProfile = new HomeProfile();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 10, 0);
		serverPanel.add(dmProfile, gbc);

		JLabel splitLabel = new JLabel("————", SwingConstants.CENTER);
		splitLabel.setPreferredSize(new Dimension(106, 20));
		splitLabel.setForeground(new Color(85, 87, 90));
		splitLabel.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 20, 0);
		serverPanel.add(splitLabel, gbc);
		
		LinkedList<ServerProfile>serverProfiles = new LinkedList<ServerProfile>();
		int i = 2;
		while(i < 12) {
			ServerProfile sp = new ServerProfile(new ImageIcon("src/resources/testicon.png").getImage(), "ID");
			serverProfiles.add(sp);
			gbc.gridx = 0;
			gbc.gridy = i;
			serverPanel.add(sp, gbc);
			i++;
		}
		i++;
		
		AddServerProfile addServerProfile = new AddServerProfile();
		gbc.gridx = 0;
		gbc.gridy = i+1;
		serverPanel.add(addServerProfile, gbc);
		
		ExploreProfile exploreProfile = new ExploreProfile();
		gbc.gridx = 0;
		gbc.gridy = i+2;
		gbc.insets = new Insets(0, 0, 30, 0);
		serverPanel.add(exploreProfile, gbc);

		Newcord.viewPanel.add(serverScrollPane);
	}
}

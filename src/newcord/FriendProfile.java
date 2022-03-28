package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendProfile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FriendProfile() {
		// Init
		setLayout(null);
		setBackground(new Color(47, 49, 54));
		setPreferredSize(new Dimension(448, 92));
		
		// Icon
		JLabel channelIcon = new JLabel();
		channelIcon.setSize(72, 72);
		channelIcon.setLocation(12, 8);
		channelIcon.setIcon(ResourceLoader.loader.getFriendProfileIcon());
		
		add(channelIcon);

		// Username
		JLabel usernameLabel = new JLabel("Friends");
		usernameLabel.setSize(328, 40);
		usernameLabel.setLocation(100, 26);
		usernameLabel.setForeground(new Color(142, 146, 151));
		usernameLabel.setFont(new Font("Whitney", Font.PLAIN, 28));
		
		add(usernameLabel);
	}
}

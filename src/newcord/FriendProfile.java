package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendProfile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FriendProfile() {
		setLayout(null);
		setBackground(new Color(47, 49, 54));
		setPreferredSize(new Dimension(448, 92));
		
		JLabel channelIcon = new JLabel();
		channelIcon.setSize(72, 72);
		channelIcon.setIcon(new ImageIcon("src/resources/friend.png"));
		channelIcon.setLocation(12, 8);
		add(channelIcon);

		JLabel usernameLabel = new JLabel("Friends");
		usernameLabel.setForeground(new Color(142, 146, 151));
		usernameLabel.setFont(new Font("Whitney", Font.PLAIN, 28));
		usernameLabel.setSize(328, 40);
		usernameLabel.setLocation(100, 26);
		add(usernameLabel);
	}
}

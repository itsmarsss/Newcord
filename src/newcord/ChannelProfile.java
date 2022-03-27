package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChannelProfile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String channelID;
	public ChannelProfile(Image userIcon, String channelID) {
		setLayout(null);
		setBackground(new Color(47, 49, 54));
		
		Image scaledIcon = userIcon.getScaledInstance(72, 72, Image.SCALE_DEFAULT);
		setPreferredSize(new Dimension(448, 92));
		JLabel channelIcon = new JLabel();
		channelIcon.setSize(72, 72);
		channelIcon.setIcon(new ImageIcon(scaledIcon));
		channelIcon.setLocation(12, 8);
		add(channelIcon);

		JLabel usernameLabel = new JLabel("Tempuser");
		usernameLabel.setForeground(new Color(142, 146, 151));
		usernameLabel.setFont(new Font("Whitney", Font.PLAIN, 28));
		usernameLabel.setSize(328, 40);
		usernameLabel.setLocation(100, 12);
		add(usernameLabel);

		setChannelID(channelID);
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
}

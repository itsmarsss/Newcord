package newcord;

import javax.swing.ImageIcon;

public class ResourceLoader {
	public static ResourceLoader loader = new ResourceLoader();
	
	// ServerList Icons
	private ImageIcon homeProfileIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/home.png"));
	private ImageIcon addProfileIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/add.png"));
	private ImageIcon exploreProfileIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/explore.png"));
	private ImageIcon tempProfileIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/temp.png"));

	// FriendList Icons
	private ImageIcon friendProfileIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/friend.png"));
	
	// Getters	
	public ImageIcon getTempProfileIcon() {return tempProfileIcon;}
	
	public ImageIcon getHomeProfileIcon() {return homeProfileIcon;}
	public ImageIcon getAddProfileIcon() {return addProfileIcon;}
	public ImageIcon getExploreProfileIcon() {return exploreProfileIcon;}
	
	public ImageIcon getFriendProfileIcon() {return friendProfileIcon;}
}

package newcord;

import javax.swing.JLabel;

public class HomeProfile extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeProfile() {
		setIcon(ResourceLoader.loader.getHomeProfileIcon());
	}
}

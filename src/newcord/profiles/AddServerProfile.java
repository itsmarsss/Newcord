package newcord.profiles;

import javax.swing.JLabel;

import newcord.ResourceLoader;

public class AddServerProfile extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddServerProfile() {
		setIcon(ResourceLoader.loader.getAddProfileIcon());
	}
}

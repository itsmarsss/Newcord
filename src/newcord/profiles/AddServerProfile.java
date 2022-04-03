package newcord.profiles;

import javax.swing.JLabel;

import newcord.newclasses.ResourceLoader;

public class AddServerProfile extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddServerProfile() {
		setIcon(ResourceLoader.loader.getAddProfileIcon());
	}
}

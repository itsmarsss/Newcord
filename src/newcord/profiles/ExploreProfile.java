package newcord.profiles;

import javax.swing.JLabel;

import newcord.ResourceLoader;

public class ExploreProfile extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExploreProfile() {
		setIcon(ResourceLoader.loader.getExploreProfileIcon());
	}
}

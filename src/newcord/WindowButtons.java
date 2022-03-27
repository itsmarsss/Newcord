package newcord;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WindowButtons extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowButtons() {
		setName("WindowsButton");
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setSize(186, 50);
		setLocation(Newcord.frame.getWidth()-186, 0);
		
		Font windowButtonFont = new Font(null, Font.PLAIN, 29);
		JLabel closeButton = new JLabel("✕", SwingConstants.CENTER);
		closeButton.setFont(windowButtonFont);
		closeButton.setSize(62, 50);
		closeButton.setOpaque(true);
		closeButton.setLocation(getWidth()-closeButton.getWidth(), 0);
		closeButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_CLOSE, 
				new Color(237, 66, 69), 
				new Color(255, 255, 255), 
				new Color(237, 66, 69), 
				new Color(255, 255, 255), 
				new Color(32, 34, 37), 
				new Color(185, 187, 190)));
		closeButton.setBackground(new Color(32, 34, 37));
		closeButton.setForeground(new Color(159, 161, 165));
		add(closeButton);

		JLabel fullscreenButton = new JLabel("□", SwingConstants.CENTER);
		fullscreenButton.setFont(windowButtonFont);
		fullscreenButton.setSize(62, 50);
		fullscreenButton.setOpaque(true);
		fullscreenButton.setLocation(closeButton.getX()-fullscreenButton.getWidth(), 0);
		fullscreenButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_FULLSCREEN, 
				new Color(40, 43, 46), 
				new Color(190, 191, 193), 
				new Color(43, 46, 50), 
				new Color(220, 220, 221), 
				new Color(32, 34, 37), 
				new Color(160, 162, 164)));
		fullscreenButton.setBackground(new Color(32, 34, 37));
		fullscreenButton.setForeground(new Color(159, 161, 165));
		add(fullscreenButton);

		JLabel minimizeButton = new JLabel("—", SwingConstants.CENTER);
		minimizeButton.setFont(windowButtonFont);		
		minimizeButton.setSize(62, 50);
		minimizeButton.setOpaque(true);
		minimizeButton.setLocation(fullscreenButton.getX()-minimizeButton.getWidth(), 0);
		minimizeButton.addMouseListener(new WindowButtonListener(
				WindowButtonListener.FRAME_MINIMIZE, 
				new Color(40, 43, 46), 
				new Color(190, 191, 193), 
				new Color(43, 46, 50), 
				new Color(220, 220, 221), 
				new Color(32, 34, 37), 
				new Color(160, 162, 164)));
		minimizeButton.setBackground(new Color(32, 34, 37));
		minimizeButton.setForeground(new Color(159, 161, 165));
		add(minimizeButton);
	}
}

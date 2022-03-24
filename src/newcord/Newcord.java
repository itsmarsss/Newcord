package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Newcord extends JFrame {
	// Newcord
	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		new Newcord();
	}
	Newcord() {
		JPanel view = new JPanel();
		
		JScrollPane serverList = new JScrollPane();
		serverList.getVerticalScrollBar().setUI(new ScrollBar());
	
		JScrollPane friendsList = new JScrollPane();
		friendsList.getVerticalScrollBar().setUI(new ScrollBar());
		
		JScrollPane channelList = new JScrollPane();
		channelList.getVerticalScrollBar().setUI(new ScrollBar());
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(2560, 1440);
		setMinimumSize(new Dimension(1280, 720));
		setLocation((int)screen.getWidth()/2-getWidth()/2, (int)screen.getHeight()/2-getHeight()/2);
		setUndecorated(true);
		getContentPane().add(view);
		view.setBackground(new Color(32, 34, 37));
		setVisible(true);
	}

}

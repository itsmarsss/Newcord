package newcord.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

import newcord.Newcord;
import newcord.newclasses.DeletePrevCharAction;
import newcord.newclasses.ResourceLoader;
import newcord.newclasses.ScrollBarUI;
import newcord.newclasses.UndoRedo;
import newcord.profiles.MemberProfile;
import newcord.profiles.MessageProfile;

public class ChatBoxArea extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel chatBoxTopBarPanel;
	private JScrollPane chatBoxScrollPane;
	private JPanel typePanel;

	private JTextArea textArea;
	private JScrollPane typeScrollPane;

	private JScrollPane membersScrollPane;

	private LinkedList<MessageProfile>messageProfiles;
	public ChatBoxArea() {
		// Init
		setName("ChatBoxArea");

		setOpaque(true);
		setBorder(null);
		setLayout(null);
		setLocation(646, 50);
		setBackground(new Color(54, 57, 63));
		setSize(Newcord.getViewPanel().getWidth()-646, Newcord.getViewPanel().getHeight()-50);

		// Chat TopBar
		chatBoxTopBarPanel = new JPanel();
		// Chat Topbar Init
		chatBoxTopBarPanel.setLayout(null);
		chatBoxTopBarPanel.setSize(getWidth(), 106);
		chatBoxTopBarPanel.setBackground(new Color(54, 57, 63));
		chatBoxTopBarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(39,40,45)));

		add(chatBoxTopBarPanel);

		// Chat Section
		JPanel chatPanel = new JPanel();
		chatBoxScrollPane = new JScrollPane(chatPanel);
		chatPanel.setBackground(new Color(54, 57, 63));

		// Chat Init
		chatBoxScrollPane.setOpaque(true);
		chatBoxScrollPane.setBorder(null);
		chatBoxScrollPane.setLocation(0, 106);
		chatBoxScrollPane.setSize(getWidth()-540, getHeight()-206);
		chatBoxScrollPane.setBackground(new Color(54, 57, 63));
		chatBoxScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		chatBoxScrollPane.getVerticalScrollBar().setBackground(getBackground());
		chatBoxScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
		chatBoxScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		chatBoxScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(46, 51, 56), new Color(32, 34, 37), true));

		add(chatBoxScrollPane);

		// Type Section
		typePanel = new JPanel();
		typePanel.setOpaque(true);
		typePanel.setBorder(null);
		typePanel.setLayout(null);
		typePanel.setLocation(30, getHeight()-100);
		typePanel.setBackground(new Color(64, 68, 75));
		typePanel.setSize(chatBoxScrollPane.getWidth()-60, 75);

		textArea = new JTextArea();
		typeScrollPane = new JScrollPane(textArea);
		typeScrollPane.setBorder(null);
		typeScrollPane.setLocation(10, 8);
		typeScrollPane.setBackground(new Color(64, 68, 75));
		typeScrollPane.setSize(typePanel.getWidth()-20, typePanel.getHeight()-16);

		typeScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		typeScrollPane.getVerticalScrollBar().setBackground(getBackground());
		typeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		typeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		typeScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new Color(46, 51, 56), new Color(32, 34, 37), true));

		typePanel.add(typeScrollPane);

		textArea.setLineWrap(true);
		textArea.setText("Message @Bunlene");
		textArea.setBackground(new Color(64, 68, 75));
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setCaretColor(new Color(255, 255, 255));
		textArea.setFont(new Font("Whitney", Font.PLAIN, 30));
		textArea.getActionMap().put(DefaultEditorKit.deletePrevCharAction, new DeletePrevCharAction());

		UndoRedo.makeUndoable(textArea);

		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				reline();
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}

		});

		add(typePanel);

		// Members Section
		JPanel membersPanel = new JPanel();
		membersScrollPane = new JScrollPane(membersPanel);
		membersPanel.setBackground(new Color(47, 49, 54));

		// MemberList Init
		membersScrollPane.setOpaque(true);
		membersScrollPane.setBorder(null);
		membersScrollPane.setSize(540, getHeight()-106);
		membersScrollPane.setBackground(new Color(47, 49, 54));
		membersScrollPane.setLocation(chatBoxScrollPane.getWidth()+5, 106);
		membersScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		membersScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		membersScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

		add(membersScrollPane);

		// Add Members
		membersPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Members
		gbc.insets = new Insets(0, 25, 12, 25);
		LinkedList<MemberProfile>memberProfiles = new LinkedList<MemberProfile>();
		int i = 0;
		while(i < 10) {
			MemberProfile cp = new MemberProfile(ResourceLoader.loader.getTempProfileIcon().getImage(), "UserID");
			memberProfiles.add(cp);
			gbc.gridx = 0;
			gbc.gridy = i;
			membersPanel.add(cp, gbc);
			i++;
		}

		// Add Messages
		chatPanel.setLayout(new GridBagLayout());

		// Messages
		gbc.insets = new Insets(0, 0, 12, 5);
		messageProfiles = new LinkedList<MessageProfile>();
		int j = 0;
		while(j < 100) {
			MessageProfile mp = new MessageProfile(ResourceLoader.loader.getTempProfileIcon().getImage(), "Bunlene", "MessageID");
			messageProfiles.add(mp);
			gbc.gridx = 0;
			gbc.gridy = j;
			chatPanel.add(mp, gbc);
			j++;
		}
		JScrollBar vertical = chatBoxScrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		vertical.setValue(vertical.getMaximum());
	}
	public void reline() {
		int h = getContentHeight()+30;
		if(h <= 500) {
			typePanel.setSize(chatBoxScrollPane.getWidth()-60, h);
			typePanel.setLocation(typePanel.getX(), getHeight()-(typePanel.getHeight()+25));
			typePanel.revalidate();
			typePanel.repaint();
			
			typeScrollPane.setSize(typePanel.getWidth()-20, typePanel.getHeight()-16);
			typeScrollPane.revalidate();
			typeScrollPane.repaint();

			chatBoxScrollPane.setSize(chatBoxScrollPane.getWidth(), getHeight()-(25+106+typePanel.getHeight()));
			chatBoxScrollPane.revalidate();
			chatBoxScrollPane.repaint();
		}
	}

	public int getContentHeight() {
		JEditorPane tempEditorPane = new JEditorPane();
		tempEditorPane.setFont(textArea.getFont());
		tempEditorPane.setText(textArea.getText()+"aa");
		tempEditorPane.setSize(textArea.getWidth(), Short.MAX_VALUE);

		return (int)tempEditorPane.getPreferredSize().getHeight();
	}

	public JPanel getChatBoxTopBarPanel() {
		return chatBoxTopBarPanel;
	}
	public JScrollPane getChatBoxScrollPane() {
		return chatBoxScrollPane;
	}
	public JScrollPane getMembersScrollPane() {
		return membersScrollPane;
	}
	public JPanel getTypePanel() {
		return typePanel;
	}
	public JScrollPane getTypeScrollPane() {
		return typeScrollPane;
	}
	public LinkedList<MessageProfile> getMessageProfiles() {
		return messageProfiles;
	}
}

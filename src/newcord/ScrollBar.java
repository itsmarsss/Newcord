package newcord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollBar extends BasicScrollBarUI {
	private final Dimension dim = new Dimension();

	private Color trackColor = Color.LIGHT_GRAY;
	private Color thumbColor = Color.GRAY;

	public ScrollBar(Color trackColor, Color thumbColor) {
		this.trackColor = trackColor;
		this.thumbColor = thumbColor;
	}
	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new JButton() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				return dim;
			}
		};
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new JButton() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				return dim;
			}
		};
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(trackColor);
		g2.fillRoundRect(r.x, r.y, r.width, r.height, r.width, r.width);
		g2.setPaint(trackColor);
		g2.drawRoundRect(r.x, r.y, r.width, r.height, r.width, r.width);
		g2.dispose();
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(thumbColor);
		g2.fillRoundRect(r.x, r.y, r.width, r.height, r.width, r.width);
		g2.setPaint(thumbColor);
		g2.drawRoundRect(r.x, r.y, r.width, r.height, r.width, r.width);
		g2.dispose();
	}

	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, width, height);
		scrollbar.repaint();
	}
}
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class DrawArea extends JComponent {
	
	private Graphics2D g2;
	private Image image;
	public Image getImage() {
		return image;
	}
	public DrawArea() {
		setDoubleBuffered(false);
		
	}	
	protected void paintComponent(Graphics g) {
		if (image == null) {		
			image = createImage(5000, 5000);
			setG2((Graphics2D) image.getGraphics());
			this.getG2().setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		 g.drawImage(image, 0, 0, null);
	 }
	public void clear() {
		  getG2().setPaint(new Color(240,255,255));
		  getG2().fillRect(0, 0, getSize().width, getSize().height);
		  getG2().setPaint(Color.black);
		  repaint();
	}

	public Graphics2D getG2() {
		return g2;
	}
	
	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}

}

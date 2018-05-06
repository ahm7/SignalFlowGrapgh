package model;

import gui.Arrow;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class Edge {

	private Node firstNode;
	private Node secondNode;
	private double value;

	public void setValue(double value) {
		this.value = value;
	}

	private float scale;
	private String id;

	public String getId() {
		return id;
	}

	public Edge(Node first, Node second, double gain) {
		this.firstNode = first;
		this.secondNode = second;
		this.value = gain;
		id = Integer.toString(first.getId()) + Integer.toString(second.getId());
	}

	public Node getFirstNode() {
		return this.firstNode;
	}

	public Node getSecondNode() {
		return this.secondNode;
	}

	public double getValue() {
		return this.value;
	}

	public void draw(Graphics2D g2) {
		
		g2.setPaint(Color.black);

		// create new QuadCurve2D.Float
		QuadCurve2D q = new QuadCurve2D.Float();
		if (firstNode.getId() < secondNode.getId()) { 
			scale = (secondNode.getPositionX() - firstNode.getPositionX()) / 2;
		} else if (firstNode.getId() > secondNode.getId()) {
			scale = ((secondNode.getPositionX() - firstNode.getPositionX()) / 2) + 350;
		}
		if (scale < 100) {
			scale = firstNode.getPositionY();
		}
		g2.setStroke(new BasicStroke(2));
		q.setCurve(firstNode.getPositionX() + (firstNode.getWidth() / 2),
				firstNode.getPositionY() + (secondNode.getHeight() / 2),
				(firstNode.getPositionX() + secondNode.getPositionX()) / 2,
				scale, secondNode.getPositionX() + (secondNode.getWidth() / 2),
				secondNode.getPositionY() + (secondNode.getHeight() / 2));
		//g2.draw(q);
		//g2.setColor(Color.red);
		g2.drawString(Double.toString(value), (int) q.getCtrlX(),
				(int) (q.getBounds().getCenterY()-5));
		 Arrow.draw(g2, q.getCtrlPt(), q.getP2(), new BasicStroke(2),new
		 BasicStroke(2), 25,q);

	}

}

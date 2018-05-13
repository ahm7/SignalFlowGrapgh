package model;

import gui.Arrow;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
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
		g2.setStroke(new BasicStroke(2));
		int distance =  (int) Math.abs(firstNode.getPositionX()-secondNode.getPositionX());
		switch (distance){
		case 150:
			if (firstNode.getId() < secondNode.getId()) {
			g2.drawLine((int)firstNode.getPositionX()+15, (int)firstNode.getPositionY()+15,(int)secondNode.getPositionX()+15, (int)secondNode.getPositionY()+15);
			g2.drawString(Double.toString(value), (int) ((firstNode.getPositionX()+(int)secondNode.getPositionX())/2),
    				(int) (firstNode.getPositionY()));
			Arrow.draw(g2, new Point((int)firstNode.getPositionX()+15,(int)firstNode.getPositionY()+25), new Point((int)secondNode.getPositionX()+15,(int)secondNode.getPositionY()+15), new BasicStroke(2),new
					 BasicStroke(2), 25);
			}else if(firstNode.getId() >secondNode.getId()){
	    		QuadCurve2D q = new QuadCurve2D.Float();
	    		q.setCurve(firstNode.getPositionX() + (firstNode.getWidth() / 2),
	    				firstNode.getPositionY() + (secondNode.getHeight() / 2),
	    				distance/200+firstNode.getPositionX(),distance*3,secondNode.getPositionX() + (secondNode.getWidth() / 2),
	    				secondNode.getPositionY() + (secondNode.getHeight() / 2));
	    		g2.drawString(Double.toString(value), (int) (q.getBounds().getCenterX()-20),
	    				(int) (q.getBounds().getCenterY()-20));
	    		g2.draw(q);    		
	    		 Arrow.draw(g2, q.getCtrlPt(), q.getP2(), new BasicStroke(2),new
	    				 BasicStroke(2), 25);
	    	}
			break;
		case 0:
			g2.drawArc((int)firstNode.getPositionX()+15, (int)firstNode.getPositionY()-20, 60, 50, 30, -360);
			g2.drawString(Double.toString(value), (int) (firstNode.getPositionX()+30),
    				(int) (firstNode.getPositionY()+15));
			Arrow.draw(g2, new Point((int)firstNode.getPositionX()+30,(int)firstNode.getPositionY()+25), new Point((int)secondNode.getPositionX()+15,(int)secondNode.getPositionY()+15), new BasicStroke(2),new
					 BasicStroke(2), 25);
			break;
	    default:
	    	if (firstNode.getId() < secondNode.getId()) {
//			g2.drawArc((int)firstNode.getPositionX()+15, (int)firstNode.getPositionY()-(distance/2)+30, distance, distance-50, 0,180 );
//			Arrow.draw(g2, new Point((int)firstNode.getPositionX()+(distance),(int)firstNode.getPositionY()-(distance)), new Point((int)secondNode.getPositionX()+15,(int)secondNode.getPositionY()+15), new BasicStroke(2),new
//					 BasicStroke(2), 25);
	    		QuadCurve2D q = new QuadCurve2D.Float();
	    		q.setCurve(firstNode.getPositionX() + (firstNode.getWidth() / 2),
	    				firstNode.getPositionY() + (secondNode.getHeight() / 2),
	    				distance+firstNode.getPositionX(),1/(distance/9),secondNode.getPositionX() + (secondNode.getWidth() / 2),
	    				secondNode.getPositionY() + (secondNode.getHeight() / 2));
	    		g2.drawString(Double.toString(value), (int) (q.getBounds().getCenterX()-5),
	    				(int) (q.getBounds().getCenterY()+5));
	    		g2.draw(q);    		
	    		 Arrow.draw(g2, q.getCtrlPt(), q.getP2(), new BasicStroke(2),new
	    				 BasicStroke(2), 25);
	    	}else if(firstNode.getId() >secondNode.getId()){
	    		QuadCurve2D q = new QuadCurve2D.Float();
	    		q.setCurve(firstNode.getPositionX() + (firstNode.getWidth() / 2),
	    				firstNode.getPositionY() + (secondNode.getHeight() / 2),
	    				distance/150+firstNode.getPositionX(),distance*1.3,secondNode.getPositionX() + (secondNode.getWidth() / 2),
	    				secondNode.getPositionY() + (secondNode.getHeight() / 2));
	    		g2.drawString(Double.toString(value), (int) (q.getBounds().getCenterX()-5),
	    				(int) (q.getBounds().getCenterY()-10));
	    		g2.draw(q);    		
	    		 Arrow.draw(g2, q.getCtrlPt(), q.getP2(), new BasicStroke(2),new
	    				 BasicStroke(2), 25);
	    	}
			 
		}

		// create new QuadCurve2D.Float
//		QuadCurve2D q = new QuadCurve2D.Float();
//		if (firstNode.getId() < secondNode.getId()) { 
//			scale = (secondNode.getPositionX() - firstNode.getPositionX()) / 2;
//		} else if (firstNode.getId() > secondNode.getId()) {
//			scale = ((secondNode.getPositionX() - firstNode.getPositionX()) / 2) + 350;
//		}
//		if (scale < 100) {
//			scale = firstNode.getPositionY();
//		}
//		g2.setStroke(new BasicStroke(2));
//		q.setCurve(firstNode.getPositionX() + (firstNode.getWidth() / 2),
//				firstNode.getPositionY() + (secondNode.getHeight() / 2),
//				(firstNode.getPositionX() + secondNode.getPositionX()) / 2,
//				scale, secondNode.getPositionX() + (secondNode.getWidth() / 2),
//				secondNode.getPositionY() + (secondNode.getHeight() / 2));
//		//g2.draw(q);
//		//g2.setColor(Color.red);
//		g2.drawString(Double.toString(value), (int) q.getCtrlX(),
//				(int) (q.getBounds().getCenterY()-5));
//		 Arrow.draw(g2, q.getCtrlPt(), q.getP2(), new BasicStroke(2),new
//		 BasicStroke(2), 25,q);

	}

}

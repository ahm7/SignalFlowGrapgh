package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class Edge {
	
	 private Node firstNode ;
	 private Node secondNode;
	 private String  value ; 
	 private int scale ;
	 boolean mins;
	 double phi;
     int barb;
	  
	 public Edge(Node first ,Node second, String value){
		 this.firstNode = first;
		 this.secondNode=second;
		 this.value = value;
		 scale =75;
		 phi = Math.toRadians(40);
	     barb = 20;
	 }

	 public Node getFirstNode(){
		 return this.firstNode;
	 }
	 public Node getSecondNode(){
		 return this.secondNode;
	 }
	 public  String getValue(){
		 return this.value;
	 }

	public void draw(Graphics2D g2) {
		g2.setPaint(Color.black);
			 
		// create new QuadCurve2D.Float
		 QuadCurve2D q = new QuadCurve2D.Float();
		 q.setCurve(firstNode.getPositionX()+(firstNode.getWidth()/2),firstNode.getPositionY()+(secondNode.getHeight()/2), (firstNode.getPositionX()+secondNode.getPositionX())/2,((firstNode.getPositionX()+secondNode.getPositionX())/2)+scale, secondNode.getPositionX()+(secondNode.getWidth()/2), secondNode.getPositionY()+(secondNode.getHeight()/2));
		 g2.draw(q);
		 if(scale>300){
			 scale-=300;
			 mins = true;
		 }else if(mins){
			 scale-=25;
		 }
		 else {
		 scale+=25;
		 }
		
	}
	 
	
}

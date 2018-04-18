package controller;

import gui.Frame;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.Edge;
import model.Node;

public class Controller {
	int nodeIndex=0;
	ArrayList<Node> nodesList;
	static Frame frame;
	static String shape;

	public Controller(Frame frame) {
	this.frame=frame;
	nodesList = new ArrayList<Node>();
	}
	
	public static void actionOnButtons(ActionEvent e) {

		if (e.getSource() == frame.nodeBtn) {
			shape="node";

		}
		else if (e.getSource() == frame.edgeBtn){
			shape="edge";
		}

	}

	public void actionOnSelect(MouseEvent e) {
		if(shape.equals("node")){
			Point point = e.getPoint();
			Node node = new Node(nodeIndex, point.x, point.y);
			nodesList.add(node);
			nodeIndex++;
			node.draw(frame.drawArea.getG2());
			frame.drawArea.repaint();
		}else if(shape.equals("edge")){
			Point point = e.getPoint();
			if(isInsideNode(point.x, point.y)!=null){
				System.out.println("yes di node");
			}else {
				//show message not involving node 
				System.out.println("not involving node");
			}
			
		}
		
	}
	 private Node isInsideNode(int x, int y) {
	        for (Node node : nodesList) {
	           if(x>node.getPositionX()&&x<node.getPositionX()+node.getWidth()){
	        	   if(y>node.getPositionY()&&y<node.getPositionY()+node.getHeight()){
	        		   return node;
	        	   }
	           }
	        }
	        return null;
	    }
}

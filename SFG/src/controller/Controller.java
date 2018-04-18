package controller;

import gui.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Edge;
import model.Node;

public class Controller {
	int nodeIndex=0;
	static ArrayList<Node> nodesList;	///////////////////3'areha
	static ArrayList<Edge> edgesList;///////////////////3'areha
	static Frame frame;
	static String shape;
	Node first,second;

	public Controller(Frame frame) {
	this.frame=frame;
	nodesList = new ArrayList<Node>();
	edgesList = new ArrayList<Edge>();
	}
	
	public static void actionOnButtons(ActionEvent e) {

		if (e.getSource() == frame.nodeBtn) {
			shape="node";

		}
		else if (e.getSource() == frame.edgeBtn){
			shape="edge";
		}else if(e.getSource()==frame.calculateBtn){
			print();
		}

	}

	private static void print() {
		for(Edge edge:edgesList)
			System.out.println(edge.getFirstNode().getId()+" "+edge.getValue()+" "+edge.getSecondNode().getId());
		System.out.println();
		for(Node node:nodesList)
		    System.out.println(node.getId());
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
			Node node =isInsideNode(point.x, point.y); 
			if(node!=null){
				if(first==null){
					first=node;
				}else if(second==null){
					second=node;
					String gain = JOptionPane.showInputDialog("Enter the gain of your edge!");//draw edge
					Edge edge = new Edge(first, second,gain);
					edgesList.add(edge);
					edge.draw(frame.drawArea.getG2());
					frame.drawArea.repaint();
					first=null;
					second=null;
				}
			}else {
				//show message not involving node 
				System.out.println("not involving node"+point);
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

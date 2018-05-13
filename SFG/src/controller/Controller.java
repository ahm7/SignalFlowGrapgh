package controller;

import gui.DrawingEngine;
import gui.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Edge;
import model.Node;

public class Controller {
	int nodeIndex = 0;
	private ArrayList<Node> nodesList; 
	private ArrayList<Edge> edgesList;
	static Frame frame;
	DrawingEngine drawingEngine;
	static String shape ="null";
	Node first, second;
	double gain;

	@SuppressWarnings("static-access")
	public Controller(Frame frame) {
		this.frame = frame;
		drawingEngine = new DrawingEngine();
		nodesList = new ArrayList<Node>();
		edgesList = new ArrayList<Edge>();
	}

	public void actionOnButtons(ActionEvent e) {

		if (e.getSource() == frame.nodeBtn) {
			shape = "node";
			frame.selected("node");

		} else if (e.getSource() == frame.edgeBtn) {
			shape = "edge";
			frame.selected("edge");
		} else if (e.getSource() == frame.calculateBtn) {
			Mason mason = new Mason(nodesList,edgesList);
			showResult(mason);
			frame.selected("calculate");
		}else if (e.getSource() == frame.hintBtn) {
			frame.selected("Hint");
			hint(getNumOfNodes());			
		}else if (e.getSource() == frame.clearBtn) {
			frame.selected("clear");
			clear();
		}

	}

	private void showResult(Mason mason) {
		
		frame.reaultArea.setForeground(new Color(26, 102, 255));
		frame.reaultArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		frame.reaultArea.setText(mason.getDetailedResult()+"<br/>Final Result"+mason.getResult());
		if(mason.error!= null){
			JOptionPane.showConfirmDialog(null,mason.error);
		return;
		}
				
	}

	private void clear() {
		nodesList= new ArrayList<>();
		nodeIndex=0;
		edgesList=new ArrayList<>();
		frame.drawArea.clear();
		frame.reaultArea.setText("");
		
	}

	private static int getNumOfNodes() {
		String	str = JOptionPane
				.showInputDialog("Enter number of nodes!");// draw
					
		return Integer.parseInt(str);
	}

	private  void hint(int numOfNodes) {
		int delta =150,x=50,y=500;
		for(int i=0;i<numOfNodes;i++){
			Node node = new Node(i, x, y);
			x+=delta;
			nodesList.add(node);
			nodeIndex++;
			drawingEngine.refresh(nodesList, edgesList, frame.drawArea);
		}

		
	}

//	private  void print() {
//		for (Edge edge : edgesList)
//			System.out.println(edge.getFirstNode().getId() + " "
//					+ edge.getValue() + " " + edge.getSecondNode().getId());
//		System.out.println();
//		for (Node node : nodesList)
//			System.out.println(node.getId());
//	}
	public void actionOnSelect(MouseEvent e) {
		if (shape.equals("node")) {
			Point point = e.getPoint();
			Node node = new Node(nodeIndex, point.x, point.y);
			nodesList.add(node);
			nodeIndex++;
			drawingEngine.refresh(nodesList, edgesList, frame.drawArea);

		} else if (shape.equals("edge")) {
			Point point = e.getPoint();
			Node node = isInsideNode(point.x, point.y);
			if (node != null) {
				if (first == null) {
					first = node;
				} else if (second == null) {
					second = node;
					
					String	str = JOptionPane
								.showInputDialog("Enter the gain of your edge!");// draw
					try{
							gain=Double.parseDouble(str);	
					// edge
					checkDrawEdge(Integer.toString(first.getId())
					+ Integer.toString(second.getId()));
                    }catch(Exception q){
						
					}
					
					first = null;
					second = null;
				}
			} else {
				// show message not involving node
				//System.out.println("not involving node" + point);
				frame.errorMessage.setText("error message : Not involving node...");
				
				Timer t = new Timer(2000, new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	frame.errorMessage.setText("");
		            }
		        });
		        t.setRepeats(false);
		        t.start();
				
			}

		}

	}

	

	private void checkDrawEdge(String string) {//check not repeated node if so make them one edge add their gains
		boolean found = false;
		for (Edge edge : edgesList) {
			if (edge.getId().equals(string)) {
				edge.setValue(gain + edge.getValue());
				found = true;
				drawingEngine.refresh(nodesList, edgesList, frame.drawArea);
				break;
			}
		}
		if (!found) {
			Edge edge = new Edge(first, second, gain);
			edgesList.add(edge);
			drawingEngine.refresh(nodesList, edgesList, frame.drawArea);
		}
	}

	private Node isInsideNode(int x, int y) {
		for (Node node : nodesList) {
			if (x > node.getPositionX()
					&& x < node.getPositionX() + node.getWidth()) {
				if (y > node.getPositionY()
						&& y < node.getPositionY() + node.getHeight()) {
					return node;
				}
			}
		}
		return null;
	}
	
}

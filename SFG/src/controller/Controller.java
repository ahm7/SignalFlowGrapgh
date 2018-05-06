package controller;

import gui.DrawingEngine;
import gui.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Edge;
import model.Node;

public class Controller {
	int nodeIndex = 0;
	private ArrayList<Node> nodesList; // /////////////////3'areha //3'ratohom mn static l private
	private ArrayList<Edge> edgesList;// /////////////////3'areha
	static Frame frame;
	DrawingEngine drawingEngine;
	static String shape;
	Node first, second;
	int gain;

	public Controller(Frame frame) {
		this.frame = frame;
		drawingEngine = new DrawingEngine();
		nodesList = new ArrayList<Node>();
		edgesList = new ArrayList<Edge>();
	}

	public static void actionOnButtons(ActionEvent e) {

		if (e.getSource() == frame.nodeBtn) {
			shape = "node";
			frame.selected("node");

		} else if (e.getSource() == frame.edgeBtn) {
			shape = "edge";
			frame.selected("edge");
		} else if (e.getSource() == frame.calculateBtn) {
			//print();
			shape = "calculation";
		}

	}

	private  void print() {
		for (Edge edge : edgesList)
			System.out.println(edge.getFirstNode().getId() + " "
					+ edge.getValue() + " " + edge.getSecondNode().getId());
		System.out.println();
		for (Node node : nodesList)
			System.out.println(node.getId());
	}
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
					if(!checkInvalidEdge()){
					String	str = JOptionPane
								.showInputDialog("Enter the gain of your edge!");// draw
							gain=Integer.parseInt(str);													// edge
					checkDrawEdge(Integer.toString(first.getId())
							+ Integer.toString(second.getId()));
					}else{
						System.out.println("not valid Edge");
					}
					first = null;
					second = null;
				}
			} else {
				// show message not involving node
				System.out.println("not involving node" + point);
			}

		}else if(shape.equals("calculation")){

			Mason mason = new Mason(nodesList,edgesList);
		}

	}

	private boolean checkInvalidEdge() {
		if(first.getId()==second.getId()){
			return true;
		}else{
		return false;
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

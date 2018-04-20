package gui;

import java.util.ArrayList;

import model.Edge;
import model.Node;

public class DrawingEngine {

	public void refresh(ArrayList<Node> nodesList, ArrayList<Edge> edgesList,
			DrawArea drawArea) {
		drawArea.clear();
		for (Edge edge : edgesList) {
			edge.draw(drawArea.getG2());

		}

		for (Node node : nodesList) {
			node.draw(drawArea.getG2());

		}
		drawArea.repaint();

	}

}

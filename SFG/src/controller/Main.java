package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import model.Node;
import gui.Frame;

public class Main {
	static Frame frame;

	
	

	public static void main(String[] args) {
		frame = new Frame();
		frame.actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionOnButtons(e);

			}
		};
		frame.set();
	}

	public static void actionOnButtons(ActionEvent e) {

		if (e.getSource() == frame.nodeBtn) {
			System.out.println("hhhhhhhhhhhh");
			
			frame.drawArea.clear();
			frame.drawArea.getG2().setPaint(Color.black);
			frame.drawArea.getG2().drawOval(10, 10, 50, 40);
			
			frame.drawArea.repaint();

		}
		else if (e.getSource() == frame.edgeBtn){
			
		}

	}

}

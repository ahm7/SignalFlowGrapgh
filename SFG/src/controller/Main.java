package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.Frame;

public class Main {
	static Frame frame;
	static Controller controller;

	public static void main(String[] args) {
		initialize();

	}

	private static void initialize() {
		frame = new Frame();
		controller = new Controller(frame);
		frame.actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.actionOnButtons(e);

			}
		};
		frame.mouseListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				controller.actionOnSelect(e);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		frame.set();

	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Main;


public class Frame  {
	JFrame frame;
	JPanel toolPanel ;
	public JButton nodeBtn;
	public JButton edgeBtn;
	public DrawArea drawArea;
	public ActionListener actionListener;
	public MouseListener mouseListener;
	Main control;
	 
	
	public void set() {
		setFrame();
		addListenerToComponents();
		control= new Main();
		frame.setVisible(true);
		
	}

	
	public void addListenerToComponents() {
		
		nodeBtn.addActionListener(actionListener);
		edgeBtn.addActionListener(actionListener);
		drawArea.addMouseListener(mouseListener);
	}



	private void setButtons() {
		
		nodeBtn = new JButton("node");
		edgeBtn = new JButton("edge");
		toolPanel.add(nodeBtn);
		toolPanel.add(edgeBtn);
	}


	private void setFrame() {
		frame = new JFrame("SFG");
		frame.setSize(700, 700);
		// frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		toolPanel = new JPanel();
	    setButtons();
		container.add(toolPanel, BorderLayout.NORTH);
		drawArea = new DrawArea();
		container.add(drawArea, BorderLayout.CENTER);
	}

	
}

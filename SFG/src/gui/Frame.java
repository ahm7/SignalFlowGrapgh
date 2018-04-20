package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	JFrame frame;
	JPanel toolPanel;
	public JButton nodeBtn;
	public JButton edgeBtn;
	public JButton calculateBtn;
	public DrawArea drawArea;
	public ActionListener actionListener;
	public MouseListener mouseListener;

	public void set() {
		setFrame();
		addListenerToComponents();
		frame.setVisible(true);

	}

	public void addListenerToComponents() {

		nodeBtn.addActionListener(actionListener);
		edgeBtn.addActionListener(actionListener);
		calculateBtn.addActionListener(actionListener);
		drawArea.addMouseListener(mouseListener);
	}

	private void setButtons() {

		nodeBtn = new JButton("node");
		nodeBtn.setBackground(Color.WHITE);
		edgeBtn = new JButton("edge");
		edgeBtn.setBackground(Color.WHITE);
		calculateBtn = new JButton("calculate");
		toolPanel.add(nodeBtn);
		toolPanel.add(edgeBtn);
		toolPanel.add(calculateBtn);
	}

	private void setFrame() {
		frame = new JFrame("SFG");
		frame.setSize(1000, 700);
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

	public void selected(String string) {
		if (string.equals("node")) {
			nodeBtn.setBackground(Color.BLACK);
			nodeBtn.setForeground(Color.WHITE);
			edgeBtn.setBackground(Color.WHITE);
			edgeBtn.setForeground(Color.BLACK);
		} else if (string.equals("edge")) {
			nodeBtn.setBackground(Color.WHITE);
			nodeBtn.setForeground(Color.BLACK);
			edgeBtn.setBackground(Color.BLACK);
			edgeBtn.setForeground(Color.WHITE);
		}

	}

}

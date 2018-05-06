package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	JFrame frame;
	JPanel toolPanel;
	public JButton nodeBtn;
	public JButton edgeBtn;
	public JButton calculateBtn;
	public JButton hintBtn;
	public DrawArea drawArea;
	public ActionListener actionListener;
	public MouseListener mouseListener;
	private ArrayList<JButton> buttons;

	public void set() {
		setFrame();
		addListenerToComponents();
		frame.setVisible(true);

	}

	public void addListenerToComponents() {

		nodeBtn.addActionListener(actionListener);
		edgeBtn.addActionListener(actionListener);
		hintBtn.addActionListener(actionListener);
		calculateBtn.addActionListener(actionListener);
		drawArea.addMouseListener(mouseListener);
	}

	private void setButtons() {
 
		buttons= new ArrayList<>();
		nodeBtn = new JButton("node");
		nodeBtn.setBackground(Color.WHITE);
		buttons.add(nodeBtn);
		edgeBtn = new JButton("edge");
		edgeBtn.setBackground(Color.WHITE);
		buttons.add(edgeBtn);
		calculateBtn = new JButton("calculate");
		calculateBtn.setBackground(Color.WHITE);
		buttons.add(calculateBtn);
		hintBtn = new JButton("Hint");
		hintBtn.setBackground(Color.WHITE);
		buttons.add(hintBtn);
		toolPanel.add(nodeBtn);
		toolPanel.add(edgeBtn);
		toolPanel.add(calculateBtn);
		toolPanel.add(hintBtn);
	}

	private void setFrame() {
		frame = new JFrame("SFG");
		frame.setSize(1000, 700);
		// frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		toolPanel = new JPanel(new GridLayout());
		setButtons();
		container.add(toolPanel, BorderLayout.NORTH);
		drawArea = new DrawArea();
		container.add(drawArea, BorderLayout.CENTER);
	}

	public void selected(String string) {
		if (string.equals("node")) {
			nodeBtn.setBackground(Color.BLACK);
			nodeBtn.setForeground(Color.WHITE);
			setWhiteExcept(nodeBtn);
		} else if (string.equals("edge")) {
			edgeBtn.setBackground(Color.BLACK);
			edgeBtn.setForeground(Color.WHITE);
			setWhiteExcept(edgeBtn);
		}else if (string.equals("calculate")) {
			calculateBtn.setBackground(Color.BLACK);
			calculateBtn.setForeground(Color.WHITE);
			setWhiteExcept(calculateBtn);
		}else if (string.equals("Hint")) {
			hintBtn.setBackground(Color.BLACK);
			hintBtn.setForeground(Color.WHITE);
			setWhiteExcept(hintBtn);
		}

	}

	private void setWhiteExcept(JButton exceptionBtn) {
		Iterator<JButton> itr = buttons.iterator();
		while(itr.hasNext()){
			JButton btn = itr.next();
			if(btn!=exceptionBtn){
			btn.setBackground(Color.WHITE);
			btn.setForeground(Color.BLACK);
		}
		}
		
	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Frame {
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame window = new Frame();
//					window.set();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	JFrame frame;
	JPanel toolPanel;
	public JButton nodeBtn;
	public JButton edgeBtn;
	public JButton calculateBtn;
	public JButton hintBtn;
	public JButton clearBtn;
	public JLabel errorMessage;
	public JLabel reaultArea;
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
		clearBtn.addActionListener(actionListener);
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
		clearBtn = new JButton("Clear");
		clearBtn.setBackground(Color.WHITE);
		buttons.add(clearBtn);
		errorMessage= new JLabel();
		errorMessage.setBackground(Color.cyan);
		errorMessage.setForeground(Color.red);
		toolPanel.add(errorMessage);
		toolPanel.add(nodeBtn);
		toolPanel.add(edgeBtn);
		toolPanel.add(calculateBtn);
		toolPanel.add(hintBtn);
		toolPanel.add(clearBtn);
	}

	private void setFrame() {
		frame = new JFrame("SFG");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		toolPanel = new JPanel(new GridLayout());
		setButtons();
		JPanel panel = new JPanel(new BorderLayout());
		container.add(toolPanel, BorderLayout.NORTH);
		container.add(panel, BorderLayout.CENTER);
		JPanel backPanel = new JPanel(new BorderLayout());
		backPanel.setBounds(0,0,1000,680);
		panel.add(backPanel);
		JPanel textPanel = new JPanel(new BorderLayout());
		reaultArea = new JLabel();
		textPanel.add(reaultArea);
		textPanel.setBackground(new Color(240,255,255));
        reaultArea.setPreferredSize(new Dimension(400,1000));
		panel.add(textPanel,BorderLayout.EAST);
		drawArea = new DrawArea();
		/* size changes causing a grey area */
		/* if new Dimension(1500,1600) it's all white */
		drawArea.setPreferredSize(new Dimension(4000,1600));
		JScrollPane scrollPane = new JScrollPane(drawArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().getModel().setValue(750);
		System.out.println(scrollPane.getVerticalScrollBar().getValue());
		backPanel.add(scrollPane);
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
		}else if (string.equals("clear")) {
			clearBtn.setBackground(Color.BLACK);
			clearBtn.setForeground(Color.WHITE);
			setWhiteExcept(clearBtn);
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

package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Node {

	int radius;
	private int id;
	private float positionX;
	private float positionY;
	private int height;
	private int width;

	public Node(int id, float positionX, float positionY) {
		radius = 20;
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		height = 25;
		width = 30;
	}

	public void draw(Graphics2D g2) {
		// frame.drawArea.clear();
		g2.setPaint(Color.black);
		g2.fillOval((int) positionX, (int) positionY, width, height);
		g2.setPaint(Color.white);
		g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		g2.drawString(Integer.toString(id + 1), positionX + 9, positionY + 20);

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public int getId() {
		return id;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

}

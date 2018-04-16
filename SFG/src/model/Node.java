package model;

public class Node {
	
	int radius;
	int id;
	float positionX;
	float positionY;
	
	public Node(int id,float positionX,float positionY) {
		radius =20;
		this.id = id;
		this.positionX=positionX;
		this.positionY=positionY;
		
	}
	
	public int getId(){
		return this.id;
	}

}

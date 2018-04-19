package model;
import java.util.ArrayList;

public class Loop {
	
	
	private ArrayList<Node> loop;
	
	public Loop(ArrayList<Node> loop){
		this.loop=loop;
		
	}

	
	public ArrayList<Node> getLoop(){
		return this.loop;
	}
}

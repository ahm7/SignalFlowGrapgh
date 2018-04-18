import java.util.ArrayList;

import model.Node;

public class path {
	
	
	private ArrayList<Node> path;
	
	public path(ArrayList<Node> path){
		this.path=path;
		
	}

	
	public ArrayList<Node> getLoop(){
		return this.path;
	}
}

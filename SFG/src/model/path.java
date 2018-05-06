package model;
import java.util.ArrayList;

public class path {
	
	
	private ArrayList<Node> path;
	private ArrayList<Edge> pathEdges;
	
	public path(ArrayList<Node> path , ArrayList<Edge> edges){
		this.path=path;
		pathEdges = new ArrayList<Edge>();
		this.setLoopEdges(edges);
	}

	
	private void setLoopEdges(ArrayList<Edge> edges) {
           for(int i=path.size()-1;i>0;i--){
					
			for(int j=0;j<edges.size();j++){
				
				if(path.get(i)==edges.get(j).getFirstNode() &&path.get(i-1)==edges.get(j).getSecondNode() ){
					pathEdges.add(edges.get(j));
					
				}
			}	
			}
		
	}


	public ArrayList<Node> getpath(){
		return this.path;
	}
	public int getGain(){
		int gain =1;
	
		for(int i=0;i<pathEdges.size();i++){
	    	gain*=pathEdges.get(i).getValue();
	    }
	
	return gain;
	}
	
	
}

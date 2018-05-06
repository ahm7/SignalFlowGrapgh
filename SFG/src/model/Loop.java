package model;
import java.util.ArrayList;
import java.util.Iterator;

public class Loop {
	
	
	private ArrayList<Node> loop;
	private ArrayList<Edge> loopEdges;
	
	public Loop(ArrayList<Node> loop, ArrayList<Edge> edges){
		this.loop=loop;
		loopEdges = new ArrayList<Edge>();
		this.setLoopEdges(edges);
	}

	
	public ArrayList<Node> getLoop(){
		return this.loop;
	}
	public ArrayList<Edge> getLoopEdges() {
		return loopEdges;
	}


	public void setLoopEdges(ArrayList<Edge> edges){
		for(int i=loop.size()-1;i>0;i--){
			
			
			for(int j=0;j<edges.size();j++){
				
				if(loop.get(i)==edges.get(j).getFirstNode() &&loop.get(i-1)==edges.get(j).getSecondNode() ){
					loopEdges.add(edges.get(j));
					
				}
			}	
			}
	}
	
	
	
	public int getGain(){
		int gain =1;
	
		for(int i=0;i<loopEdges.size();i++){
	    	gain*=loopEdges.get(i).getValue();
	    }
	
	return gain;
	}
}

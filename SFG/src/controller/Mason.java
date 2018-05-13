package controller;

import java.util.ArrayList;


import java.util.Iterator;

import model.Edge;
import model.Loop;
import model.Node;
import model.NonTouchingLoops;
import model.findingLoops;
import model.path;
import model.pathNonTouchLoops;


public class Mason {
	
	private double delta;
	private findingLoops findingloops;
	private NonTouchingLoops nonTouchingLoops;
	private ArrayList<path> paths; 
	private ArrayList<Loop> loops;
	private ArrayList<ArrayList<ArrayList<Loop>>> nonTouching;
	private ArrayList<Node> nodesList;
	private ArrayList<Edge> edgesList;
	private double Delta;
	
	public Mason(ArrayList<Node> nodesList, ArrayList<Edge> edgesList) {
		
		this.nodesList=nodesList;
		this.edgesList=edgesList;
		findingloops = new findingLoops(nodesList, edgesList);
		paths= findingloops.getPaths();
		loops = findingloops.getLoops();
		nonTouchingLoops = new NonTouchingLoops(loops);
		nonTouching = nonTouchingLoops.nonTouching;
		Delta=getDelta(loops,nonTouching);
	}
	
	public double getResult(){
		return (getNumerator()/Delta);
		
	}
	
	
	private double getDelta(ArrayList<Loop> loops,ArrayList<ArrayList<ArrayList<Loop>>> nonTouching){
		boolean sign = true;//positive
		delta =1;
		Iterator<Loop> itr = loops.iterator();
	    while(itr.hasNext()) {
	    	Loop loop = itr.next();
	    	delta-=loop.getGain();
	    	
	    
	    }
	    
	    double temp=1;
	    double term=0;
	    for(int i=0;i<nonTouching.size();i++){
	    	for(int j=0;j<nonTouching.get(i).size();j++){
	    		for(int x=0;x<nonTouching.get(i).get(j).size();x++){
	    			temp*=nonTouching.get(i).get(j).get(x).getGain();
	    			
	    		}
	    		term+=temp;
	    		temp=1;
	    	}
	    	if(sign){
	    	delta+=term;
	    	term=0;
	    	sign=false;
	        }else{
	    	delta-=term;
	    	term=0;
	    	sign=true;
	        }
	    }
		return delta;
		
	}
	private double getDeltaOfK(path pathK){
		
		pathNonTouchLoops pLoops = new pathNonTouchLoops(nodesList,edgesList, pathK);
		ArrayList<Loop> pathNonTouchingLoops = pLoops.getNewLoops();
		nonTouchingLoops = new NonTouchingLoops(pathNonTouchingLoops);
		nonTouching = nonTouchingLoops.nonTouching;
		System.out.println("size "+pathNonTouchingLoops.size());
		return this.getDelta(pathNonTouchingLoops, nonTouching);
	}
	private double getNumerator(){
		int numerator=0;
		Iterator<path> itr = paths.iterator();
	    while(itr.hasNext()) {
	    	path path= itr.next();
	    	numerator+=path.getGain()*this.getDeltaOfK(path);
	    }
	    
	   
		return numerator;
		
	}
	public String getDetailedResult(){
		String loops="<html>Loops :<br/>";
		ArrayList<String> array =findingloops.getPathsInListOfString();
		for(int i=0;i<array.size();i++){
		loops+=	array.get(i)+"<br/>";
		}
		array=nonTouchingLoops.getLoopsInListOfString();
		for(int i=0;i<array.size();i++){
			loops+=	array.get(i)+"<br/>";
		}
		loops+="</html>";
		return loops;
	}

}

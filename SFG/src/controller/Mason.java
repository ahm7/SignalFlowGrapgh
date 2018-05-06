package controller;

import java.util.ArrayList;


import java.util.Iterator;

import model.Edge;
import model.Loop;
import model.Node;
import model.NonTouchingLoops;
import model.findingLoops;
import model.path;


public class Mason {
	
	private int delta;
	private findingLoops findingloops;
	private NonTouchingLoops nonTouchingLoops;
	private ArrayList<path> paths; 
	private ArrayList<Loop> loops;
	private ArrayList<ArrayList<ArrayList<Loop>>> nonTouching;
	
	public Mason(ArrayList<Node> nodesList, ArrayList<Edge> edgesList) {
		delta =1;
		findingloops = new findingLoops(nodesList, edgesList);
		paths= findingloops.getPaths();
		loops = findingloops.getLoops();
		nonTouchingLoops = new NonTouchingLoops(loops);
		nonTouching = nonTouchingLoops.nonTouching;
		getDelta();
	}
	
	
	
	private int getDelta(){
		for(int i=0;i<loops.size();i++){
			for(int j=0;j<loops.get(i).getLoop().size();j++){
				System.out.print(loops.get(i).getLoop().get(j).getId());
			}
			System.out.println();
		}
		boolean sign = true;//positive
		
		Iterator<Loop> itr = loops.iterator();
	    while(itr.hasNext()) {
	    	Loop loop = itr.next();
	    	delta-=loop.getGain();
	    	
	    
	    }
	    
	    System.out.println("Deltaaa"+delta);
	    int temp=1;
	    int term=0;
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
	    System.out.println(delta);
		return delta;
		
	}

}
a
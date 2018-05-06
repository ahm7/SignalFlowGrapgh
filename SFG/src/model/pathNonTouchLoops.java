package model;

import java.util.ArrayList;

public class pathNonTouchLoops {
	
	private path thePath ;
	private ArrayList<Loop> allLoops;
	private ArrayList<Integer> theTouchArrange;
	public pathNonTouchLoops(ArrayList<Loop> allLoops , path p){
		
		this.allLoops=allLoops;
		this.thePath=p;
		checkTouching();

	}
	
	

	
	private void  checkTouching(){
		int k=0;
		int size = allLoops.size();
		for(int i=0; i<size;i++){
			for(int j=0;j<allLoops.get(i-k).getLoop().size();j++){
				
				if(thePath.getpath().contains(allLoops.get(i-k).getLoop().get(j))){
				 
					allLoops.remove(i-k);
					k++;
					break;
				}
			}
			
			
		}
		
		
		
		
	}
	
	public ArrayList<Loop>   getNewLoops(){
		return allLoops;
	}
	
	

}

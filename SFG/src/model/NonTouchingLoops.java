package model;

import java.util.ArrayList;

public class NonTouchingLoops {

	public ArrayList<ArrayList<ArrayList<Loop>>> nonTouching = new ArrayList<>();

	private ArrayList<Loop> loops = new ArrayList<>();
    
	
	
	public NonTouchingLoops (ArrayList<Loop> loops){
		
		this.loops=loops;
		checktwoNonTouch();
		
		
	}
	
	
	private boolean isTouching (ArrayList<Node> loop1 , ArrayList<Node> loop2){
		
		boolean flag = false;
		for(int i=0;i<loop1.size();i++){
			
			if(loop2.contains(loop1.get(i))){
				flag = true;
				break ;
			}
					
		}
	
		/*for(int i=0;i<loop1.size();i++){
			System.out.print(loop1.get(i).getId()+" ");
		}
		System.out.println(" ");
		for(int i=0;i<loop2.size();i++){
			System.out.print(loop2.get(i).getId()+" ");

		}
		System.out.println(" ");*/
		return flag;
	}
	
	
	
	private void checktwoNonTouch(){
		
		
		for(int i=0;i<this.loops.size()-1;i++){
			
			for(int j=i+1;j<loops.size();j++){
				
				if(isTouching(loops.get(i).getLoop(),loops.get(j).getLoop())){

					
				}else{

				if(nonTouching.isEmpty()){
					nonTouching.add(new ArrayList<ArrayList<Loop>>());
				}
				ArrayList<Loop> temp = new ArrayList<>();
				temp.add(loops.get(i));
				temp.add(loops.get(j));
				System.out.println(temp);
				nonTouching.get(0).add(temp);
				check(temp);
				
			}
			
		}}
		
		for (int i=0;i<nonTouching.size();i++){
			
			
			 DublicationRemoval(i);
		}
		
		
		
	}


	private void DublicationRemoval(int y) {
		ArrayList<Integer> carryDublicatePosition = new ArrayList<>();
		 for(int i=0;i<nonTouching.get(y).size()-1;i++){
				boolean flag = false ; 

			 for(int j=i+1; j<nonTouching.get(y).size();j++){
					 
				 
				 for(int k=0;k<nonTouching.get(y).get(j).size();k++){
				if(!nonTouching.get(y).get(i).contains(nonTouching.get(y).get(j).get(k))){

					flag =true;
					break;
				}
				
				 
				 }
				 
				 if(!flag){
					 carryDublicatePosition.add(j);
					 
				 }
				 
				 
		 }
			 
		 
		 
		 
		 }
		
		 
	}


	private void check(ArrayList<Loop> temp) {
		
		
		for(int i=0;i<loops.size();i++){
			int counter = 0;
			for(int j=0;j<temp.size();j++){
				
				if(!isTouching(temp.get(j).getLoop(),loops.get(i).getLoop())){
					
					counter ++;
		
				}	else{break;	}
				
			}
			
			if(counter == temp.size()){
				
				//System.out.println(temp.size()+"temp");
				ArrayList<Loop> clone = new ArrayList<>();

				for(int q=0;q<temp.size();q++){
					clone.add(temp.get(q));
				}
				clone.add(loops.get(i));
				
				if(nonTouching.size()< clone.size()-1){
					
					nonTouching.add(new ArrayList<ArrayList<Loop>>());

				}
				
				if(!dublicate(clone.size()-2,clone) || nonTouching.get(clone.size()-2).size()==0){
				nonTouching.get( clone.size()-2).add(clone);
				
				check(clone);
				}
				
			}
			
		}
		
		
		
		
	}


	private boolean dublicate(int y, ArrayList<Loop> clone) {
		//System.out.println(nonTouching.get(y).size());
		 for(int i=0;i<nonTouching.get(y).size();i++){
				int temp=0;

			 for(int j=0; j<clone.size();j++){
				if(!nonTouching.get(y).get(i).contains(clone.get(j))){
				break;
				 
				 }else{
					 temp ++;
				 }
				
			 }
			 if(temp == clone.size()){
				 return true;
			 }
			 }
				 
		
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}

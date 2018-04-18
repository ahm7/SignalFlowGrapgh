import java.util.ArrayList;
import java.util.Stack;

import model.Node;

public class findingLoops {

	
	
	private Stack<Node> TraceTube= new Stack<>();
	private ArrayList<Node>nodes;
	private ArrayList<Edges>edges;
	private ArrayList<Loop>loops= new ArrayList<>();
	private ArrayList<path>paths= new ArrayList<>();

	private ArrayList<ArrayList<Edges>>edgesOfLoops=new ArrayList<>();
	private ArrayList<ArrayList<Edges>>finaledgesOfLoops=new ArrayList<>();

	private int currentRow=0;
	
	public  findingLoops(ArrayList<Node>nodes,ArrayList<Edges>edges) {
		
		this.nodes=nodes;
		this.edges=edges;
		fillChildrens();
		Trace(nodes.get(0));
		findingLoopsEdges();
		TraceTube.clear();
		TracePath(nodes.get(0));
      // TODO Auto-generated constructor stub
	}
	
	private ArrayList<ArrayList<Node>> childrens = new ArrayList<>();
	
	
 private void fillChildrens(){
		
for(int i=0;i<this.nodes.size();i++){
	ArrayList<Node> temp = new ArrayList<>();
	childrens.add(temp);
}

for(int i=0;i<this.edges.size();i++){
	int positionofFirstNode= edges.get(i).getFirstNode().getId();
	int positionofSecondNode= edges.get(i).getSecondNode().getId();
	int size = childrens.get(positionofFirstNode).size();
	//Child temp = new Child(size,nodes.get(positionofSecondNode));
	childrens.get(positionofFirstNode).add(nodes.get(positionofSecondNode));
}


		
	}
 



 private void Trace (Node e ){
	 //`System.out.println(e.getId()+1);
	// System.out.println(e.getId());
ArrayList<Node> theloop = new ArrayList();
int size = TraceTube.size();
//System.out.println(size);
	 if ( TraceTube.contains(e) ) {
		 
	   Stack <Node>temp1 =  new Stack<>();
	   Stack <Node>temp =  new Stack<>();
	   for(int i=0;i<size;i++){
		   temp1.push(TraceTube.pop());
	   }
	   for(int i=0;i<size;i++){
		   Node test = temp1.pop();
		   temp.push(test);
		   TraceTube.push(test);
	   }
	   

	  
	   theloop.add(e);
	   for( int I=0 ; I< size; I++){ 
		//   System.out.println(temp.peek().getId()+" "+e.getId());
	 if(temp.peek().getId() == e.getId()){
	   theloop.add(temp.pop());
	   Loop myLoop = new  Loop(theloop);
	   loops.add(myLoop);
	   ArrayList<Edges> fill = new ArrayList<>();
	   edgesOfLoops.add(fill);
	  // System.out.println();
	  
	 break;

	 }
	 theloop.add(temp.pop()); 
	 
	 }}
	 else{
		 TraceTube.push(e);
		 ArrayList<Node> temp =childrens.get(e.getId());
	 for(int i=0; i< childrens.get(e.getId()).size();i++){
		 for(int ii=0;ii<size+1;ii++){
			 if(i>0 &&TraceTube.peek().getId()!= e.getId()){
				 TraceTube.pop();
			 }
		 }
	 Trace(temp.get(i));

	 }



	 }


	 }

 
public ArrayList<Loop> getLoops(){
	return loops;
}

private void findingLoopsEdges(){
	
	
	for(int i=0;i<loops.size();i++){
		
		for(int j=loops.get(i).getLoop().size()-1;j>0;j--){
			
		
			for(int y=0;y<edges.size();y++){
				
				if(edges.get(y).getFirstNode()==loops.get(i).getLoop().get(j) &&edges.get(y).getSecondNode()==loops.get(i).getLoop().get(j-1) ){
					edgesOfLoops.get(i).add(edges.get(y));
					System.out.print(edges.get(y)+" ");
					
				}
				
			}
			
			
		}
		System.out.println(" ");
		
		
		
	}
	
	
	
	
	for(int u=0;u<edgesOfLoops.size()-1;u++){
		int t =0;
		for(int z=u+1;z<edgesOfLoops.size();z++){
			
			if(edgesOfLoops.get(z).size()== edgesOfLoops.get(u).size()){
				for(int o=0;o<edgesOfLoops.get(u).size();o++){
					
					for(int e=0;e<edgesOfLoops.get(z).size();e++){
						
						if(edgesOfLoops.get(u).get(o)==edgesOfLoops.get(z).get(e)){
							t++;
						}
						
					}
					if(t==edgesOfLoops.get(z).size()){
						t=-1;
						break;
					}
				}	
				
				if(t==-1){
					edgesOfLoops.get(z).clear();
				}
				
			}
			
			
		}
		
		
		
		
	}
	
	for(int q=0;q<edgesOfLoops.size();q++){
		
		if(edgesOfLoops.get(q).size() != 0){
			finaledgesOfLoops.add(edgesOfLoops.get(q));
		}
	}
	
	
}

private void TracePath(Node n){
	if(n.getId()==0){
		TraceTube.push(n);
	}
	int size = TraceTube.size();
	if(n.getId()== nodes.get(nodes.size()-1).getId()){
		TraceTube.push(n);

		System.out.println(n.getId()+"isdes");
		ArrayList<Node> thePath = new ArrayList<>();
		 for(int i=0; i <size;i++) {

			 thePath.add(TraceTube.pop());
		 }
		 for(int i=size-1; i >=0;i--) {
			 
         TraceTube.push(thePath.get(i));		 
}
		 path myPath = new path(thePath) ;
		 paths.add(myPath);
      
	}
	else{
		
		
		TraceTube.push(n);
		for(int i=0;i<childrens.get(n.getId()).size();i++){
			 for(int ii=0;ii<size+1;ii++){
				 if(i>0 &&TraceTube.peek().getId()!= n.getId()){
					 TraceTube.pop();
				 }
			 }
			if(childrens.get(n.getId()).get(i).getId()>n.getId()){
				System.out.println(n.getId()+1 + " "+(childrens.get(n.getId()).get(i).getId()+1)+" "+ "comparison" );
				TracePath(childrens.get(n.getId()).get(i));
			}
		}
		
		
		
	}
	
	
}

public void printPaths(){
	
	for(int i=0;i<paths.size();i++){
		for(int j=0;j<paths.get(i).getLoop().size();j++){
			System.out.print(paths.get(i).getLoop().get(j).getId()+1+" ");
			
		}
		System.out.println( " path "+paths.get(i).getLoop().size());
	}
}



}
 /*private void searchForLoops(Child child){
	// TraceTube.push(node);
	 Node node = child.node;
	  if we get a loop 
	 if (node.getId()==this.currentRow){
		 
		Stack<Child> temp = TraceTube;
		 ArrayList<Node>loop = new ArrayList<>();
		 loop.add(node);
		 for(int i=0;i<TraceTube.size()-1;i++){
			 if(temp.peek().node==node){
				 loop.add(temp.pop().node);
				 searchForLoops(temp.peek());
				 break;
			 }
			 loop.add(temp.pop().node);

		 }
		 Loop currenLoop = new Loop(loop);
		 loops.add(currenLoop);
		 
		 
	 }
	 end of the condition of getting a loop 
	 
	  check for dublication
	 else  if(TraceTube.contains(child)){
		 int stop = 0;
		 while (stop!=1){
		 if((child.position)+1<childrens.get(TraceTube.peek().position).size()){
			 Child temp =  childrens.get(TraceTube.peek().position+1).get(child.position+1);
			 searchForLoops(temp);
			 stop=1;
		 }else{
			 
			TraceTube.pop();
			child=TraceTube.peek();
			if(TraceTube.size()==0){
				break;
			}
			 
		 }
		 }
	 }
	
	 end of the check 
	 else if (child.node.getId()==childrens.size()){
		 this.currentRow++;
		 if(currentRow< childrens.size()){
			 Node n = nodes.get(currentRow);
			 Child t = new Child(0, n);
			 searchForLoops(t);
		 }
		 
	 }
 }
 
 
condition of end
	

}*/
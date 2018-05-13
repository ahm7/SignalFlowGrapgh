package model;
import java.util.ArrayList;
import java.util.Stack;
 
public class findingLoops {
 
 
 
	private Stack<Node> TraceTube = new Stack<>();
	private ArrayList<Node>nodes;
	private ArrayList<Edge>edges;
	private ArrayList<Loop>loops;
	private ArrayList<path>paths= new ArrayList<>();
	private ArrayList<ArrayList<Edge>>edgesOfLoops=new ArrayList<>();
	private ArrayList<ArrayList<Edge>>finaledgesOfLoops=new ArrayList<>();
	private int sinkPosition=0;
 
	private int currentRow=0;
 
	public  findingLoops(ArrayList<Node>nodes,ArrayList<Edge>edges) {
		loops= new ArrayList<>();
		this.nodes=nodes;
		this.edges=edges;
		fillChildrens();
		Trace(nodes.get(0));
		findingLoopsEdges();
		TraceTube.clear();
		findSinkNode();
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
	   Loop myLoop = new  Loop(theloop,edges);
	   ///////////////ana zwetha
	   loops.add(myLoop);
	   ArrayList<Edge> fill = new ArrayList<>();
	   edgesOfLoops.add(fill);
	  // System.out.println();
 
	 break;
 
	 }
	 theloop.add(temp.pop()); 
 
	 }}
	 else{
		 TraceTube.push(e);
		 //System.out.println(e.getId());
		 ArrayList<Node> temp =childrens.get(e.getId());
		 //System.out.println( e.getId()+" "+"ope"+" "+ childrens.get(e.getId()).size());
 
	 for(int i=0; i< childrens.get(e.getId()).size();i++){
		 size = TraceTube.size();
 
		 while(e.getId() != TraceTube.peek().getId()){
			// System.out.println(TraceTube.peek().getId());
			 TraceTube.pop();
 
		 }
 
	 Trace(temp.get(i));
 
	 }
return;
	 }
 
 
	 }
 
 
public ArrayList<Loop> getLoops(){
	return loops;
}
public ArrayList<path> getPaths(){
	return paths;
}
 
private void findingLoopsEdges(){
 
 
	for(int i=0;i<loops.size();i++){
 
		for(int j=loops.get(i).getLoop().size()-1;j>0;j--){
 
 
			for(int y=0;y<edges.size();y++){
 
				if(edges.get(y).getFirstNode()==loops.get(i).getLoop().get(j) &&edges.get(y).getSecondNode()==loops.get(i).getLoop().get(j-1) ){
					edgesOfLoops.get(i).add(edges.get(y));
					//System.out.print(edges.get(y)+" ");
 
				}
 
			}
 
 
		}
		//System.out.println(" ");
 
 
 
	}
 
 
 
	int po=0;	
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
					System.out.println(u);
	loops.remove(z-po);
	po++;
	t=0;
				}
 
			}
 
 
		}
 
 
 
 
	}
 
	for(int q=0;q<edgesOfLoops.size();q++){
 
		if(edgesOfLoops.get(q).size() != 0){
			finaledgesOfLoops.add(edgesOfLoops.get(q));
		}
	}
	//System.out.println(finaledgesOfLoops.size()+" edges");
	int i=0;
for(int q=0;q<edgesOfLoops.size();q++){
 
		if(edgesOfLoops.get(q).size() == 0){
			//System.out.println(q);
		//	loops.remove(q-i);
		}
		i++;
	}
 
 
 
 
}
 
 
private void TracePath(Node n){
 
	if(sinkPosition == -1 || sinkPosition == -2  ){
	}else{
 
	if(n.getId()==0){
		TraceTube.clear();
		TraceTube.push(n);
		System.out.println(n.getId());
	}
	int size = TraceTube.size();
	if(n.getId()== sinkPosition){
		TraceTube.push(n);
 
		//System.out.println(n.getId()+"isdes");
		ArrayList<Node> thePath = new ArrayList<>();
		 for(int i=0; i <size;i++) {
 
			 thePath.add(TraceTube.pop());
		 }
		 for(int i=size-1; i >=0;i--) {
 
         TraceTube.push(thePath.get(i));		 
}
		 path myPath = new path(thePath,edges) ;
		 paths.add(myPath);
 
	}
	else{
 
 
		TraceTube.push(n);
		for(int i=0;i<childrens.get(n.getId()).size();i++){
			 while(n.getId() != TraceTube.peek().getId()){
					// System.out.println(TraceTube.peek().getId());
					 TraceTube.pop();
 
				 }
			if(!TraceTube.contains(childrens.get(n.getId()).get(i))){
				//System.out.println(n.getId()+1 + " "+(childrens.get(n.getId()).get(i).getId()+1)+" "+ "comparison" );
				TracePath(childrens.get(n.getId()).get(i));
			}
		}
 
 
	}
	}
 
 
}
 
private void findSinkNode(){
	sinkPosition = -1;
	int NumOfNode = nodes.size();
	sinkPosition = NumOfNode-1;
	/*int counter = 0 ; 
	for(int j=0;j<NumOfNode;j++){
		int y=0;
	for(int i=0; i<edges.size();i++){
 
 
		if(edges.get(i).getFirstNode().getId()==j){
			y=1;
				break;
		}
 
	}
 
	if(y==0){
		sinkPosition = j;
		counter ++;
		if(counter >1){
 
			sinkPosition= -2;
			break;
		}
	}
	}
 
	System.out.println(counter +" "+sinkPosition);*/
}
public  ArrayList<String>getLoopsInListOfString(){
	ArrayList<String>LoopsInListOfString=new ArrayList<>();
	for(int i=0; i < loops.size();i++){
		String thisLoop="L" ;
		thisLoop+= i+1;
		thisLoop+= " = ";
		for(int j=0; j < loops.get(i).getLoop().size(); j++){
			thisLoop+= loops.get(i).getLoop().get(j).getId()+1;
		}
		
		LoopsInListOfString.add(thisLoop);
	
	}

	
	
	return LoopsInListOfString ;
	
}


public  ArrayList<String>getPathsInListOfString(){
	ArrayList<String>PathsInListOfString=new ArrayList<>();
	for(int i=0; i < paths.size();i++){
		String thisLoop="p" ;
		thisLoop+= i+1;
		thisLoop+= " = ";
		for(int j=0; j < paths.get(i).getpath().size(); j++){
			thisLoop+= paths.get(i).getpath().get(j).getId()+1;
		}
		
		PathsInListOfString.add(thisLoop);
	
	}

	
	
	return PathsInListOfString ;
	
}
 
 
 
}
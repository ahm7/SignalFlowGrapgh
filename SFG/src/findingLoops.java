import java.util.ArrayList;
import java.util.Stack;

import model.Node;

public class findingLoops {

	
	
	private Stack<Child> TraceTube= new Stack<>();
	private ArrayList<Node>nodes;
	private ArrayList<Edges>edges;
	private ArrayList<Loop>loops;
	private int currentRow=0;
	
	public  findingLoops(ArrayList<Node>nodes,ArrayList<Edges>edges) {
		
		this.nodes=nodes;
		this.edges=edges;
		
      // TODO Auto-generated constructor stub
	}
	
	private ArrayList<ArrayList<Child>> childrens = new ArrayList<>();
	
	
 private void fillChildrens(){
		
for(int i=0;i<this.nodes.size();i++){
	ArrayList<Child> temp = new ArrayList<>();
	childrens.add(temp);
}

for(int i=0;i<this.edges.size();i++){
	int positionofFirstNode= edges.get(i).getFirstNode().getId();
	int positionofSecondNode= edges.get(i).getSecondNode().getId();
	int size = childrens.get(positionofFirstNode).size();
	Child temp = new Child(size,nodes.get(positionofSecondNode));
	childrens.get(positionofFirstNode).add(temp);
}


		
	}
 
 
 private void searchForLoops(Child child){
	// TraceTube.push(node);
	 Node node = child.node;
	 /* if we get a loop */
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
	 /*end of the condition of getting a loop */
	 
	 /* check for dublication*/
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
	
	/* end of the check */
	 else if (child.node.getId()==childrens.size()){
		 this.currentRow++;
		 if(currentRow< childrens.size()){
			 Node n = nodes.get(currentRow);
			 Child t = new Child(0, n);
			 searchForLoops(t);
		 }
		 
	 }
 }
 
 
/*condition of end*/
	

}
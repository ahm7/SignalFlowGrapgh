import model.Node;

public class Edges {
	
	 private Node firstNode ;
	 private Node secondNode;
	 private String  value ; 
	 public Edges(Node first ,Node second, String value){
		 this.firstNode = first;
		 this.secondNode=second;
		 this.value = value;
	 }

	 public Node getFirstNode(){
		 return this.firstNode;
	 }
	 public Node getSecondNode(){
		 return this.secondNode;
	 }
	 public  String getValue(){
		 return this.value;
	 }
	 
	 
	
}

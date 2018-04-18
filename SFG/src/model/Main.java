package model;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
  ArrayList<Node>nodes= new ArrayList<>();
  ArrayList<Edge>edges= new ArrayList<>();
  ArrayList<Loop>loops=new ArrayList<>();
	
  for(int i=0;i<8;i++){
	  Node a = new Node(i,0,0);
	  nodes.add(a);
  }
  Edge a = new Edge(nodes.get(0), nodes.get(1), "h");
  Edge b = new Edge(nodes.get(1), nodes.get(2),"g");
  Edge c = new Edge(nodes.get(2), nodes.get(3), "h");
  Edge d = new Edge(nodes.get(3), nodes.get(4),"g");
  Edge e = new Edge(nodes.get(3), nodes.get(6), "h");
  Edge f = new Edge(nodes.get(4), nodes.get(5),"g");
  Edge g = new Edge(nodes.get(5), nodes.get(4), "h");
  Edge h = new Edge(nodes.get(5), nodes.get(6),"g");
  Edge i = new Edge(nodes.get(5), nodes.get(7), "h");
  Edge j = new Edge(nodes.get(6), nodes.get(2),"g");
  Edge k = new Edge(nodes.get(6), nodes.get(7), "h");
  Edge l = new Edge(nodes.get(7), nodes.get(1),"g");
  Edge m = new Edge(nodes.get(7), nodes.get(5),"g");

		 edges.add(a);
		 edges.add(b);
		 edges.add(c);
		edges.add(d);
		 edges.add(e);
		 edges.add(f);
		 edges.add(g);
		 edges.add(h);
		 edges.add(i);
		edges.add(j);
		 edges.add(k);
		 edges.add(l);
		 edges.add(m);
		 
		 

		 findingLoops test = new findingLoops(nodes, edges);
		 loops=test.getLoops();
		 test.printPaths();
		 System.out.println(loops.size()+"size");
		 ArrayList<Node> t = new ArrayList<>();
		 t=loops.get(1).getLoop();
		 
		for (int q=0;q<loops.size();q++){
			
			for(int p=0;p<loops.get(q).getLoop().size();p++){
				
				System.out.print(loops.get(q).getLoop().get(p).getId()+1+" ");;
				
			}
			System.out.println(" ");
			
		}
		 
		 
		 
		
	}
	
	
}

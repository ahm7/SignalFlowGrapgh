import java.util.ArrayList;

import model.Node;

public class Main {

	public static void main(String[] args) {
		
		
  ArrayList<Node>nodes= new ArrayList<>();
  ArrayList<Edges>edges= new ArrayList<>();
  ArrayList<Loop>loops=new ArrayList<>();
	
  for(int i=0;i<8;i++){
	  Node a = new Node(i,0,0);
	  nodes.add(a);
  }
  Edges a = new Edges(nodes.get(0), nodes.get(1), "h");
  Edges b = new Edges(nodes.get(1), nodes.get(2),"g");
  Edges c = new Edges(nodes.get(2), nodes.get(3), "h");
  Edges d = new Edges(nodes.get(3), nodes.get(4),"g");
  Edges e = new Edges(nodes.get(3), nodes.get(6), "h");
  Edges f = new Edges(nodes.get(4), nodes.get(5),"g");
  Edges g = new Edges(nodes.get(5), nodes.get(4), "h");
  Edges h = new Edges(nodes.get(5), nodes.get(6),"g");
  Edges i = new Edges(nodes.get(5), nodes.get(7), "h");
  Edges j = new Edges(nodes.get(6), nodes.get(2),"g");
  Edges k = new Edges(nodes.get(6), nodes.get(7), "h");
  Edges l = new Edges(nodes.get(7), nodes.get(1),"g");
  Edges m = new Edges(nodes.get(7), nodes.get(5),"g");

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

package model;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		

  ArrayList<Node>nodes= new ArrayList<>();
  ArrayList<Edge>edges= new ArrayList<>();
  ArrayList<Loop>loops=new ArrayList<>();
  ArrayList<path> paths = new ArrayList<>();
	
  for(int i=0;i<8;i++){
	  Node a = new Node(i,0,0);
	  nodes.add(a);
  }
  Edge a = new Edge(nodes.get(0), nodes.get(1), 5);
  Edge b = new Edge(nodes.get(1), nodes.get(0),6);
  Edge c = new Edge(nodes.get(1), nodes.get(2), 7);
  Edge d = new Edge(nodes.get(2), nodes.get(3),8);
  Edge e = new Edge(nodes.get(3), nodes.get(2), 9);
  Edge f = new Edge(nodes.get(3), nodes.get(4),10);
  Edge g = new Edge(nodes.get(4), nodes.get(5), 11);
  Edge h = new Edge(nodes.get(5), nodes.get(4),12);
  Edge i = new Edge(nodes.get(5), nodes.get(6), 13);
  Edge j = new Edge(nodes.get(6), nodes.get(7),14);
  Edge k = new Edge(nodes.get(7), nodes.get(6), 15);
 

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
		
		 
		 findingLoops test = new findingLoops(nodes, edges);
		 loops=test.getLoops();
		 paths = test.getPaths();
		 
		 for(int it=0; it < paths.size();it++){
			 for(int ff = 0 ; ff<paths.get(it).getpath().size();ff++){
				 
				 System.out.print(paths.get(it).getpath().get(ff).getId());
			 }
			 System.out.println("path");
		 }
		/* for(int ii=0;ii<loops.size();ii++){
			 for(int kj=0;kj<loops.get(ii).getLoop().size();kj++){
				 
				 System.out.print(loops.get(ii).getLoop().get(kj).getId()+" ");
			 }
			 System.out.println(" ");
		 }
		 */
		 NonTouchingLoops q = new NonTouchingLoops(loops);
		 ArrayList<ArrayList<ArrayList<Loop>>> t = new  ArrayList<>();
		 t=q.nonTouching;
		 System.out.println(q.nonTouching.size()+" kk" + q.nonTouching.get(2).size());
		 	

		 	}
		 /*test.printPaths();
		 System.out.println(loops.size()+"size");
		 ArrayList<Node> t = new ArrayList<>();
		 t=loops.get(1).getLoop();
		 
		for (int q=0;q<loops.size();q++){
			
			for(int p=0;p<loops.get(q).getLoop().size();p++){
				
				System.out.print(loops.get(q).getLoop().get(p).getId()+1+" ");;
				
			}
			System.out.println(" ");
			
		}
		 
	*/	 
		 
		
	
	
	
}

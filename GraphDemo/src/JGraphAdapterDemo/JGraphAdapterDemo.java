package JGraphAdapterDemo;

import java.util.Set;

import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.GraphIterator;

        


public class JGraphAdapterDemo  {
    
    public static void main(String[] args) { 
 // create a JGraphT graph
        
      SimpleWeightedGraph g = new SimpleWeightedGraph( DefaultWeightedEdge.class );
 
        // create a visualization using JGraph, via an adapter             
        // TO BE DONE LATER
      
      
         /*********************START TEST EXAMPLE 4: ******************************/  
        // add some sample data (graph manipulated via JGraphT)
        
        g.addVertex("0");
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");
        g.addVertex("5");
        g.addVertex("6");
        g.addVertex("7");
        g.addVertex("8");
         
        //Add edges
	DefaultWeightedEdge e1 =  (DefaultWeightedEdge) g.addEdge("0", "1");
	g.setEdgeWeight (e1, 4);
                    
	DefaultWeightedEdge e2 = (DefaultWeightedEdge) g.addEdge("0", "7");
	g.setEdgeWeight (e2, 8);
        
	DefaultWeightedEdge e3 = (DefaultWeightedEdge) g.addEdge("1", "2");
	g.setEdgeWeight (e3, 8);
		
	DefaultWeightedEdge e4 = (DefaultWeightedEdge) g.addEdge("1", "7");
	g.setEdgeWeight (e4, 11);
        
	DefaultWeightedEdge e5 = (DefaultWeightedEdge) g.addEdge("7", "8");
	g.setEdgeWeight (e5, 7);
		
        
	DefaultWeightedEdge e6= (DefaultWeightedEdge) g.addEdge("7", "6");
	g.setEdgeWeight (e6, 1);
        
	DefaultWeightedEdge e7 = (DefaultWeightedEdge) g.addEdge("2", "8");
	g.setEdgeWeight (e7, 2);
		
        DefaultWeightedEdge e8 = (DefaultWeightedEdge) g.addEdge("2", "3");
	g.setEdgeWeight (e8, 7);
		
	DefaultWeightedEdge e9 = (DefaultWeightedEdge) g.addEdge("2", "5");
	g.setEdgeWeight (e9, 4);
        
	DefaultWeightedEdge e10 = (DefaultWeightedEdge) g.addEdge("3", "4");
	g.setEdgeWeight (e10, 9);
		
	DefaultWeightedEdge e11 = (DefaultWeightedEdge) g.addEdge("3", "5");
	g.setEdgeWeight (e11, 14);

        
	DefaultWeightedEdge e12 = (DefaultWeightedEdge) g.addEdge("6", "8");
	g.setEdgeWeight (e12, 6);
		
        DefaultWeightedEdge e13 = (DefaultWeightedEdge) g.addEdge("5", "6");
	g.setEdgeWeight (e13, 2);
		
        DefaultWeightedEdge e14 =  (DefaultWeightedEdge) g.addEdge("4", "5");
	g.setEdgeWeight (e14, 10);
     
        //GET SHORTEST PATH USING DIJKSTRA'S ALGORITHM
        
        // Prints the shortest path from vertex 0 to vertex 4. This certainly
        // exists for our particular directed graph.
       
        System.out.println("Shortest path from 0 to 4:");
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg =
            new DijkstraShortestPath<>(g);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("0");
        System.out.println(iPaths.getPath("4") + "\n");
        
        // Prints the shortest path from vertex 4 to vertex 0. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the variable "path"; must be null.
        System.out.println("Shortest path from 4 to 0:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> cPaths = dijkstraAlg.getPaths("4");
        System.out.println(cPaths.getPath("0"));
        
        
         //get MinimumSpanninngTree using Kruskal's Algorithm
        
        KruskalMinimumSpanningTree<String, DefaultEdge> spanTree =
            new KruskalMinimumSpanningTree<>(g);
        //Set<DefaultEdge> spanTreeSet = spanTree.getMinimumSpanningTreeEdgeSet();
        System.out.println("\n Kruskal minimum Spanning Tree");
        System.out.println(spanTree.getSpanningTree().toString());
        
                
        
        //get MinimumSpanninngTree using prim's Algorithm
        
        PrimMinimumSpanningTree<String, DefaultEdge> primSpanTree =
            new PrimMinimumSpanningTree<>(g);
        //Set<DefaultEdge> primspanTreeSet = primSpanTree.getSpanningTree();
        System.out.println("prim minimum Spanning Tree");
        System.out.println(primSpanTree.getSpanningTree().toString());
         /*********************END EXAMPLE 4: ******************************/ 
      
    
    }
}
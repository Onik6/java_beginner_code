package JGraphAdapterDemo_BFS_DFS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JApplet;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;
import org.jgrapht.alg.vertexcover.*;
/**
* A demo applet that shows how to use JGraph to visualize JGraphT graphs.
*
*
*/
public class JGraphAdapterDemo_VERTEX_COVER extends JApplet {
private static final Color DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );
//
private JGraphModelAdapter m_jgAdapter;
/**
* @see java.applet.Applet#init().
*/
@Override
public void init( ) {
// create a JGraphT graph
ListenableGraph g = new ListenableDirectedGraph( DefaultEdge.class );
// create a visualization using JGraph, via an adapter
m_jgAdapter = new JGraphModelAdapter( g );

JGraph jgraph = new JGraph( m_jgAdapter );
adjustDisplaySettings( jgraph );
getContentPane().add( jgraph );
resize( DEFAULT_SIZE );

/*********************START EXAMPLE 1: ******************************/
//ADD NODES
g.addVertex("V1");
g.addVertex ("V2");
g.addVertex ("V3"); 
g.addVertex ("V4"); 
g.addVertex ("V5");
g.addVertex ("V6"); 
g.addVertex ("V7");
g.addVertex ("V8");
g.addVertex ("V9");

//SECOND GRAPH 
g.addVertex ("VV1");
g.addVertex ("VV2");
g.addVertex ("VV3"); 
g.addVertex ("VV4"); 
g.addVertex ("VV5");
g.addVertex ("VV6"); 
g.addVertex ("VV7");
g.addVertex ("VV8");
g.addVertex ("VV9");
		


//ADD EDGES
g.addEdge ("V1","V3"); 
g.addEdge ("V1","V5");
g.addEdge ("V1","V6");
g.addEdge ("V1","V7");
g.addEdge ("V2","V3"); 
g.addEdge ("V2","V5");
g.addEdge ("V3","V4");
g.addEdge ("V8","V7");
g.addEdge ("V5","V2"); 
g.addEdge ("V4","V6");
g.addEdge ("V5","V8"); 
g.addEdge ("V8","V5");
g.addEdge ("V9","V7");
g.addEdge ("V6","V9");
g.addEdge ("V9","V1"); 
g.addEdge ("V1","V9");
g.addEdge ("V1","V8"); 
g.addEdge ("V8","V1");
g.addEdge ("V3","V2");
g.addEdge ("V2","V4");
g.addEdge ("V4","V2"); 
g.addEdge ("V1","V9");
g.addEdge ("V9","V6"); 
g.addEdge ("V7","V1");
g.addEdge ("V5","V1");
g.addEdge ("V3","V1");
g.addEdge ("V4","V1"); 
g.addEdge ("V1","V9");

//ADD EDGES SECOND GRAPH

g.addEdge ("VV3","VV2"); 
g.addEdge ("VV3","VV4");
g.addEdge ("VV1","VV5");
g.addEdge ("VV1","VV7");
g.addEdge ("VV1","VV9"); 
g.addEdge ("VV1","VV8");
g.addEdge ("VV1","VV3");
g.addEdge ("VV1","VV6");



System.out.println();
positionVertexAt( "V2", 400, 10 );
positionVertexAt( "V5", 200, 100 );
positionVertexAt( "V3", 400, 100 );
positionVertexAt( "V4", 600, 100 );
positionVertexAt( "V1", 400, 200 );
positionVertexAt( "V6", 600, 200 );
positionVertexAt( "V8", 200, 300 );
positionVertexAt( "V7", 400, 300 );
positionVertexAt( "V9", 600, 300 );

positionVertexAt( "VV2", 400, 500 );
positionVertexAt( "VV5", 200, 600 );
positionVertexAt( "VV3", 400, 600 );
positionVertexAt( "VV4", 600, 600 );
positionVertexAt( "VV1", 400, 700 );
positionVertexAt( "VV6", 600, 700 );
positionVertexAt( "VV8", 200, 800 );
positionVertexAt( "VV7", 400, 800 );
positionVertexAt( "VV9", 600, 800 );

}



    private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );
        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;
        try {
            colorStr = getParameter( "bgcolor" );
        }
        catch( Exception e ) {}
            if( colorStr != null ) {
             c = Color.decode( colorStr );
            }
            jg.setBackground( c );
    }
    
    private void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );
        Map attr = cell.getAttributes( );
        Rectangle2D b = GraphConstants.getBounds( attr );
        GraphConstants.setBounds( attr, new Rectangle2D.Double( x, y,
        b.getWidth(), b.getHeight() ));
        Map cellAttr = new HashMap( );
        cellAttr.put( cell, attr );
        m_jgAdapter.edit( cellAttr, null, null, null );
    }
}
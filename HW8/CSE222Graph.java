import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

/**
 * This class represents a graph used in the CSE222 project.
 */
public class CSE222Graph 
{
    private Map<String, List<String>> graph = new HashMap<>(); 
    private String start;
    private String end;
    private int numV=0;
    
    /**
     * Constructs a CSE222Graph object based on the provided map.
     *
     * @param map The CSE222MAP object representing the map.
     */
    public CSE222Graph(CSE222MAP map)
    {
        String [][] arr2D = map.getMap();
        this.start = map.getStart();
        this.end = map.getEnd();
   // Iterate over the 2D array and create vertices and edges
        for(int i=0; i< arr2D.length; i++){
        for(int j=0; j< arr2D[0].length; j++){
            if( Integer.parseInt( arr2D[i][j] )== 0 ){
            String a = Integer.toString(i) + "," + Integer.toString(j);
            addNewVertex(a);
                if(i>0 && Integer.parseInt( arr2D[i-1][j] )==0 )
                {
                String b = Integer.toString(i-1) + "," + Integer.toString(j);
                addNewEdge(a, b); 
                  
                }
                
                if(i< arr2D.length -1  && Integer.parseInt( arr2D[i+1][j])==0)
                {
                String b = Integer.toString(i+1) + "," + Integer.toString(j);
                addNewEdge(a, b); 
                  
                    
                }
              
                if(j>0 && Integer.parseInt( arr2D[i][j-1])==0)
                {
                String b = Integer.toString(i) + "," + Integer.toString(j-1);
                addNewEdge(a, b); 
                  
                  
                }
                
                if( i>0 && j>0 && Integer.parseInt( arr2D[i-1][j-1])==0)
                {
                String b = Integer.toString(i-1) + "," + Integer.toString(j-1);
                addNewEdge(a, b); 
                  
                  
                }
                
                if( j<arr2D[0].length-1 && j>0 && Integer.parseInt( arr2D[i][j+1])==0)
                {
                String b = Integer.toString(i) + "," + Integer.toString(j+1);
                addNewEdge(a, b); 
                  
                  
                }
              
                if( i>0 && j<arr2D[0].length-1 && Integer.parseInt( arr2D[i-1][j+1])==0)
                {
                String b = Integer.toString(i-1) + "," + Integer.toString(j+1);
                addNewEdge(a, b); 
                  
                }
              
                if( j<arr2D[0].length-1 && i< arr2D.length -1 && Integer.parseInt( arr2D[i+1][j+1])==0)
                {
                String b = Integer.toString(i+1) + "," + Integer.toString(j+1);
                addNewEdge(a, b); 
                  
                  
                }
              
                if( i< arr2D.length -1 && j>0 && Integer.parseInt( arr2D[i+1][j-1])==0)
                {
                String b = Integer.toString(i+1) + "," + Integer.toString(j-1);
                addNewEdge(a, b); 
                  
                }
                        
            }
        }
    }
       

    } 

    /**
     * Returns the list of adjacent vertices for the given vertex.
     *
     * @param vertex The vertex for which to retrieve the adjacent vertices.
     * @return The list of adjacent vertices.
     */
    public List<String> getAdjacent(String vertex)
    {
        return graph.get(vertex);
    }
    
     /**
     * Returns the start vertex of the graph.
     *
     * @return The start vertex.
     */
    public String getStart()
    {
        return start;
    }
    
     /**
     * Returns the end vertex of the graph.
     *
     * @return The end vertex.
     */
    public String getEnd()
    {
        return end;
    }

    /**
     * Adds a new vertex to the graph.
     *
     * @param v The vertex to add.
     */
    public void addNewVertex(String v)
    {
        graph.put(v, new LinkedList<String>());
    }

    /**
     * Adds a new edge between the source and destination vertices.
     *
     * @param source   The source vertex.
     * @param dest     The destination vertex.
     */
    public void addNewEdge(String source, String dest)
    {
        if(! graph.containsKey(source))
        addNewVertex(source);
        // if(! graph.containsKey(dest))
        // addNewVertex(dest);

        graph.get(source).add( dest);
    //    graph.get(dest).add(dest);
    }

    /**
     * Prints the total number of vertices in the graph.
     */
    public void countVertices()   
    {   
    System.out.println("Total number of vertices: "+ graph.keySet().size() +" " +numV);   
    }
    
    /**
     * Returns all the vertices in the graph.
     *
     * @return The set of all vertices.
     */
    public Set<String> getAllVertex()
    {
        return graph.keySet();
    }


     /**
     * Returns a string representation of the graph.
     *
     * @return The string representation of the graph.
     */
    @Override
    public String toString()   
    {   
        StringBuilder builder = new StringBuilder();   
        //foreach loop that iterates over the keys  
        for (String v : graph.keySet())   
        {   
            builder.append(v.toString() + ": ");   
            //foreach loop for getting the vertices  
            for ( String w : graph.get(v))   
            {   
                builder.append("(" + w.toString() + ")");   
            }   
            builder.append("\n");   
        }   
        return (builder.toString());   
    }   
}   


import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

/**
 * This class implements the Breadth-First Search (BFS) algorithm to find the shortest path in a graph.
 */
public class BFSAlgorithm 
{
    private CSE222Graph graph;


    /**
     * Constructs a BFSAlgorithm object with the given graph.
     *
     * @param graph The graph to perform BFS on.
     * @throws Exception If an error occurs during the initialization.
     */
    public BFSAlgorithm(CSE222Graph graph) throws Exception
    {
        this.graph = graph;
    }

    /**
     * Finds and returns the shortest path between the start and end vertices.
     *
     * @return The shortest path as a list of vertices.
     * @throws Exception If the path is not found.
     */
    public List<String> givePath() throws Exception
    {
        List<String> temp = breadthFirstSearch( graph.getStart(), graph.getEnd());

        if(graph.getStart() != temp.get(0) && graph.getEnd() != temp.get( temp.size()-1) )
        {
            throw new Exception("Road is not found.");
        }

        return temp;
    }

    /**
     * Performs the Breadth-First Search algorithm to find the shortest path.
     *
     * @param start The starting vertex of the path.
     * @param end   The destination vertex of the path.
     * @return The shortest path as a list of vertices.
     */
    private List<String> breadthFirstSearch(String start , String end) 
    {
        Queue<String> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();        
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while(! queue.isEmpty())
        {
            String current = queue.poll();

            if(current.equals(end))
            break;



            for(String adjacent : graph.getAdjacent(current))
            {
                if(!visited.contains(adjacent))
                {
                    queue.offer(adjacent);
                    visited.add(adjacent);
                    if(parent.keySet().contains(adjacent))
                    ;//do anything
                    else
                    parent.put(adjacent,current);
                }
            }
            

        }
        return shortestPath(parent, start, end);
    }

     /**
     * Reconstructs and returns the shortest path from the parent map.
     *
     * @param parent The parent map containing the parent-child relationships.
     * @param start  The starting vertex of the path.
     * @param end    The destination vertex of the path.
     * @return The shortest path as a list of vertices.
     */
    private List<String> shortestPath(Map<String,String> parent, String start, String end )
    {
        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) 
        {
            path.add(0, current);  
            current = parent.get(current);
           // System.out.println(current);
            
            if(current != null && current.equals(start))
            {
                path.add(0, start);
                break;
            }


        }
        return path;
    }
   
}

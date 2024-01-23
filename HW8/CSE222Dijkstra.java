import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class implements the Dijkstra's algorithm to find the shortest path in a graph.
 */
public class CSE222Dijkstra 
{
    private CSE222Graph graph;
    private Map<String, Integer> distance;
    private Map<String, String> previous;
    private Set<String> computed;
    private Set<String> process;

     /**
     * Constructs a CSE222Dijkstra object with the given graph.
     *
     * @param graph The graph to perform Dijkstra's algorithm on.
     */
    CSE222Dijkstra(CSE222Graph graph)
    {
        this.graph = graph;
    }

    /**
     * Finds the shortest path between the given start and end vertices.
     *
     * @param start The start vertex.
     * @param end   The end vertex.
     * @return A list of vertices representing the shortest path.
     * @throws Exception If the road is not found.
     */
    public List<String> giveShortPath(String start , String end) throws Exception
    {
        dijkstra( start);
        List<String> temp = givePath(end);

        if(temp.get(0) != start && temp.get( temp.size()-1) != end)
        {
            throw new Exception("road is not found.");
        }

        return temp;
    }

    /**
     * Performs Dijkstra's algorithm to compute the shortest path from the start vertex to all other vertices.
     *
     * @param start The start vertex.
     */
    public void dijkstra(String start)
    {
        distance = new HashMap<>();
        previous = new HashMap<>();
        computed = new HashSet<>();
        process = new HashSet<>();

        for(String ver : graph.getAllVertex())
        {
            distance.put(ver, Integer.MAX_VALUE);
            process.add(ver);
        }
        distance.put(start, 0);



        while( !process.isEmpty())
        {
            String current = getSmallestVertex();
            
            computed.add(current);
            process.remove(current);

            for(String adjacent : graph.getAdjacent(current))
            {
                int newValue = distance.get(current) + 1; 
                //we add 1 because the weight of each edges is 1
                if(newValue < distance.get(adjacent))
                {
                    distance.put(adjacent, newValue);
                    previous.put(adjacent, current);
                }
            }
        }
    }

    /**
     * Retrieves the shortest path from the end vertex to the start vertex.
     *
     * @param end The end vertex.
     * @return A list of vertices representing the shortest path.
     */
    public List<String> givePath( String end)
    {
        List<String> path = new ArrayList<>();
        String current = end;

        while(current != null)
        {
            path.add(0,current);
            current = previous.get(current);
        }



        return path;
    }

    /**
     * Returns the vertex with the smallest distance value from the set of uncomputed vertices.
     *
     * @return The vertex with the smallest distance value.
     */
    private String getSmallestVertex()
    {
        String min = "a";
        int minValue = Integer.MAX_VALUE;
        for(String str : process)
        {
            if( distance.get(str) < minValue )
            {
                minValue = distance.get(str);
                min = str;
            }
        }

        return min;
    }
    
}

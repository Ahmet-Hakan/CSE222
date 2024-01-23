import java.util.List;


public class TestCases implements Runnable {

    private  String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }


    
    public void test() throws Exception
    {
    	
    	System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        long startTime = System.currentTimeMillis();

        CSE222MAP map = new CSE222MAP(FileName ); 
        CSE222Graph graph = new CSE222Graph(map);


        BFSAlgorithm bfs = new BFSAlgorithm(graph);

        CSE222Dijkstra dijkstra = new CSE222Dijkstra(graph);
        dijkstra.dijkstra( graph.getStart());
        
       CSE222MAP map2 = new CSE222MAP(FileName); 

        List<String> path = dijkstra.givePath( graph.getEnd());
        map2.toPng("Dijkstra" + FileName);
        map2.drawLine( path, "Dijkstra" + FileName);
        map.printPathToFile(path, FileName, "dijkstra");
        System.out.println( FileName+ " dijkstra path distance: " +path.size());

        List<String> bfsPath =  bfs.givePath();
        map.toPng("bfs" + FileName);
        map.drawLine( bfsPath, "bfs" +FileName);
        map.printPathToFile(bfsPath, FileName,"bfs");
        System.out.println( FileName+ " bfs path distance: " + bfsPath.size());

        long endTime = System.currentTimeMillis();
        long executionTimeInSeconds = (endTime - startTime) / 1000;
        System.out.println( FileName + " Execution time: " + executionTimeInSeconds + " seconds");

    }

    @Override
    public void run() 
    {
        try
        {
         test();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
/**
 * This class represents a map used in the CSE222 project.
 */
public class CSE222MAP 
{
    private String start;
    private String end;
    private String[][] map = new String[500][500];

     /**
     * Constructs a CSE222MAP object based on the provided file.
     *
     * @param filename The name of the file containing the map data.
     * @throws Exception If there is an error reading the file or the road is undefined.
     */
    public CSE222MAP(String filename  ) throws Exception
    {
        File file = new File(filename);
        Scanner myScanner = new Scanner(file);
        start = myScanner.nextLine();
        end = myScanner.nextLine();
        

        int i=0;
        while (myScanner.hasNextLine())
        {
            String temp = myScanner.nextLine();
            String[] arrStrings= temp.split(",");
            map[i] = arrStrings;
            i++;
        }
        myScanner.close();
        testMap();
    }

    /**
     * Validates the map to ensure the start and end points are valid roads.
     *
     * @throws Exception If the road is undefined.
     */
    private void testMap() throws Exception
    {
        String[] arr = start.split(",");
        int temp = Integer.parseInt( map[ Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] ) ;  
        arr = end.split(",");
        int temp1 = Integer.parseInt( map[ Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] ) ;  
        if(temp !=0 || temp1 !=0)
        throw new Exception("The road is undefined.");        
    }

     /**
     * Returns the start point of the map.
     *
     * @return The start point.
     */
    public String getStart(){return start;}

    public void printPathToFile(List<String> path, String string, String algo) throws Exception
    {
        File myObj = new File("path" + string);
        FileWriter myWriter = new FileWriter(algo + "path" + string);
        for(String ver : path)
        {
            myWriter.write(ver + "\n");
        }
        myWriter.close();
    }

    /**
     * Returns the end point of the map.
     *
     * @return The end point.
     */
    public String getEnd(){return end;}

    
    /**
     * Returns the map as a 2D array.
     *
     * @return The map as a 2D array.
     */
    public String[][] getMap(){return map;}

   
    /**
     * Converts the map to a PNG image and saves it to the specified file.
     *
     * @param filename The name of the PNG file to save.
     * @throws Exception If there is an error creating the PNG image.
     */
    public void toPng(String filename)throws Exception{
		int col = map[0].length; 
		int raw = map.length; 
		    BufferedImage image = new BufferedImage(raw, col, BufferedImage.TYPE_INT_ARGB);
		    for (int i = 0; i < raw; i++) {
			for (int j = 0; j < col; j++) {
			    String str = map[i][j];
			    int color = (str.equals("1")) ? 0xFF84B1D0: 0xFFFFFFFF; 
			    image.setRGB(j, i, color);
			}
		    }

		    ImageIO.write(image, "png", new File(  filename+ ".png"));
	}
		
    /**
     * Draws a line on the PNG image representing the given line of vertices.
     *
     * @param line     The line of vertices to draw.
     * @param filename The name of the PNG file to modify.
     * @throws Exception If there is an error reading or modifying the PNG image.
     */
	public void drawLine(List<String> line, String filename)throws Exception{
	
        
		int RGB = 0xFFAA0000; 
		for(String v : line){
		    BufferedImage image = ImageIO.read(new File(filename+ ".png"));
            String[] arr = v.split(",");
            int x = Integer.parseInt( arr[0]);
            int y = Integer.parseInt(arr[1]);
		    image.setRGB(y, x, RGB);
		    ImageIO.write(image, "PNG", new File(filename+ ".png"));
		}
	}

    
    
}
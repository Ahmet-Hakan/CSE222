import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;                 
import java.util.Map;



/**
 * This class implements the bubble sort algorithm to sort a map.
 * @author: Ahmet Hakan Sevinc
 */
public class BubbleSort 
{
    myMap orginalMap;
    myMap sortedMap;

    /**
     * Constructs a new BubbleSort object with the specified map.
     * @param orginalMap the map to be sorted
     */
    public BubbleSort(myMap orginalMap)
    {
        this.orginalMap = orginalMap;
        LinkedHashMap <String, info> temp= bubbleSort (this.orginalMap.getMap());
        sortedMap = new myMap( temp);
    }

    /**
     * Sorts the specified map using the bubble sort algorithm.
     * @param map the map to be sorted
     * @return a new sorted map
     */
    private LinkedHashMap <String, info> bubbleSort(LinkedHashMap <String, info> map)
    {
        List < Map.Entry<String, info>> entriesArr = new ArrayList<>(map.entrySet());
        int pass =1;
        boolean exchanges = false;
        do {
            exchanges = false;
            for(int i=0; i< entriesArr.size() - pass; i++)
            {
                Map.Entry<String, info> max = entriesArr.get(i);
                if(max.getValue().compareTo( entriesArr.get(i +1).getValue()) > 0)
                {
                    Map.Entry<String, info> temp = entriesArr.get(i);
                    entriesArr.set(i, entriesArr.get(i+1));
                    entriesArr.set(i+1, temp);
                    exchanges = true;
                }
            }
            pass++;
        } while (exchanges);

        LinkedHashMap<String, info> result = new LinkedHashMap<>();
        for (int i=0; i< entriesArr.size();i++)
        {
            Map.Entry<String, info>next = entriesArr.get(i);
            result.put(next.getKey(), next.getValue());
        }
        return result;
    }

    /**
     * Displays the sorted map.
     */
    public void display()
    {
        System.out.println("Bubble sorted map is: ");
        System.out.println(sortedMap);
    }
    
}
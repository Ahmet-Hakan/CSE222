import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;                 
import java.util.Map;
/**
 * This class implements the insertion sort algorithm on a given map.
 *@author Ahmet Hakan Sevinc
 */
public class InsertionSort 
{
    myMap orginalMap;
    myMap sortedMap;

    /**
     * Constructor for the InsertionSort class.
     * @param orginalMap The map to be sorted.
     */
    public InsertionSort(myMap orginalMap)
    {
        this.orginalMap = orginalMap;
        LinkedHashMap <String, info> temp= insertionSort (this.orginalMap.getMap());
        sortedMap = new myMap( temp);
    }

    /**
     * Sorts the given map using the insertion sort algorithm.
     * @param map The map to be sorted.
     * @return A new sorted LinkedHashMap.
     */
    private LinkedHashMap <String, info> insertionSort(LinkedHashMap <String, info> map)
    {
        List < Map.Entry<String, info>> entriesArr = new ArrayList<>(map.entrySet());
        for(int nextPos =1; nextPos < entriesArr.size(); nextPos ++ )
        {
            Map.Entry<String, info> nextEntry = entriesArr.get(nextPos);
            while(nextPos > 0 && nextEntry.getValue().compareTo( entriesArr.get(nextPos-1).getValue()) < 0)
            {
                entriesArr.set(nextPos, entriesArr.get(nextPos-1));
                nextPos --;
            }
            entriesArr.set(nextPos, nextEntry);
        }

        
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
        System.out.println("Insertion sorted map is: ");
        System.out.println(sortedMap);
    }
    
}
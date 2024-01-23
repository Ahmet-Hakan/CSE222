import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;                 
import java.util.Map;
/**
 * This class implements the quicksort algorithm on a given map.
 *@author Ahmet Hakan Sevinc
 */
public class QuickSort 
{
    myMap orginalMap;
    myMap sortedMap;

    /**
     * Constructor for the QuickSort class.
     * @param orginalMap The map to be sorted.
     */
    public QuickSort(myMap orginalMap)
    {
        this.orginalMap = orginalMap;
        LinkedHashMap <String, info> temp= quickSort (this.orginalMap.getMap());
        sortedMap = new myMap( temp);
    }

    /**
     * Sorts the given map using the quicksort algorithm.
     * @param map The map to be sorted.
     * @return A new sorted LinkedHashMap.
     */
    private LinkedHashMap <String, info> quickSort(LinkedHashMap <String, info> map)
    {
        List < Map.Entry<String, info>> entriesArr = new ArrayList<>(map.entrySet());
        sort(entriesArr, 0, entriesArr.size() -1);

        LinkedHashMap<String, info> result = new LinkedHashMap<>();
        for (int i=0; i< entriesArr.size();i++)
        {
            Map.Entry<String, info>next = entriesArr.get(i);
            result.put(next.getKey(), next.getValue());
        }
        return result;
        
    }

    /**
     * Sorts the given list of entries using the quicksort algorithm.
     * @param entriesArr The list of entries to be sorted.
     * @param first The first index of the subarray to be sorted.
     * @param last The last index of the subarray to be sorted.
     */
    private void sort(List < Map.Entry<String, info>> entriesArr, int first, int last )
    {
        if(first < last)
        {
            int pivIndex = partition(entriesArr, first, last);
            sort(entriesArr, first, pivIndex-1);
            sort(entriesArr, pivIndex+1, last);
        }
    }

    /**
     * Partitions the given list of entries around a pivot element.
     * @param entriesArr The list of entries to be partitioned.
     * @param first The first index of the subarray to be partitioned.
     * @param last The last index of the subarray to be partitioned.
     * @return The final position of the pivot element.
     */
    private int partition(List < Map.Entry<String, info>> entriesArr, int first, int last)
    {
        Map.Entry<String, info> pivot = entriesArr.get(first);
        int up = first, down = last;
        do {
            while(up < last && (pivot.getValue().compareTo( entriesArr.get(up).getValue()) >= 0))
            {
                up ++;
            }

            while( pivot.getValue().compareTo( entriesArr.get(down).getValue()) < 0)
            {
                down --;
            }

            if(up < down)
            {
                Map.Entry<String, info> temp = entriesArr.get(up);
                entriesArr.set(up, entriesArr.get(down));
                entriesArr.set(down, temp);
            }
            
        } while (up < down);

        Map.Entry<String, info> temp = entriesArr.get(first);
        entriesArr.set(first, entriesArr.get(down));
        entriesArr.set(down, temp);

        return down;
    }

    /**
     * Displays the sorted map.
     */
    public void display()
    {
        System.out.println("Quick sorted map is: ");
        System.out.println(sortedMap);
    }
    
}
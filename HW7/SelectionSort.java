import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;                 
import java.util.Map;
/**
 * This class implements the selection sort algorithm to sort a given map.
 *@author: Ahmet Hakan Sevinc
 */    
public class SelectionSort 
{
    myMap orginalMap;
    myMap sortedMap;

    /**
     * Constructs a new SelectionSort object with the given map.
     * @param orginalMap The map to be sorted.
     */
    public SelectionSort(myMap orginalMap)
    {
        this.orginalMap = orginalMap;
        LinkedHashMap <String, info> temp= selectionSort (this.orginalMap.getMap());
        sortedMap = new myMap( temp);
    }

     /**
     * Sorts the given map using the selection sort algorithm.
     * @param map The map to be sorted.
     * @return A new sorted LinkedHashMap.
     */
    private LinkedHashMap <String, info> selectionSort(LinkedHashMap <String, info> map)
    {
        List < Map.Entry<String, info>> entriesArr = new ArrayList<>(map.entrySet());
        Map.Entry<String, info> min;
        Map.Entry<String, info> next;
        int size = map.size();
        //String [] keys = map.keySet().toArray(new String [size]);
        for(int i= 0; i < size-1 ; i++)
        {
            for (int j = i+1; j < size ; j++) 
            {
                min = entriesArr.get(i);
                next = entriesArr.get(j);
                if( min.getValue().compareTo( next.getValue()) > 0  )
                {
                    Map.Entry<String, info> temp = entriesArr.get(i);
                    entriesArr.set(i , entriesArr.get(j) );
                    entriesArr.set(j, temp);
                }
                
            }
        }
        
        LinkedHashMap<String, info> result = new LinkedHashMap<>();
        for (int i=0; i< entriesArr.size();i++)
        {
            next = entriesArr.get(i);
            result.put(next.getKey(), next.getValue());
        }
        return result;
        }
    /**
    * Displays the sorted map to the standard output.
    */ 
    public void display()
    {
        System.out.println("Selection sorted map is: ");
        System.out.println(sortedMap);
    }
}

/*
 * Here is a report on the SelectionSort class:

The SelectionSort class implements the selection sort algorithm to sort a given map. 
The class has two instance variables: originalMap, which stores the original map to be sorted, and sortedMap, which stores the sorted map.

The constructor of the class takes in a myMap object as a parameter and initializes the originalMap instance variable. 
It then calls the selectionSort method with the map from the myMap object to obtain a sorted map,
which is used to create a new myMap object that is stored in the sortedMap instance variable.

The selectionSort method takes in a LinkedHashMap as a parameter and sorts it using the selection sort algorithm. 
The time complexity of selection sort is O(n^2) in the worst, average, and best cases, where n is the number of elements in the map. 
This means that for large maps, selection sort can be quite slow.

The display method displays the sorted map to the standard output.

In summary, the SelectionSort class provides an implementation of the selection sort algorithm for sorting maps. 
However, due to its time complexity of O(n^2), it may not be suitable for sorting large maps.
 */

 // else if(min.getValue().compareTo( next.getValue()) == 0)
                // {
                //     String str = min.getKey();
                //     int count1=0,count2=0;

                //     for(String a: keys)
                //     {
                //         count1 ++;
                //         if( a == str)
                //         break;
                //     }

                //     str = next.getKey();
                //     for(String a: keys)
                //     {
                //         count2 ++;
                //         if( a == str)
                //     break;
                //     }

                //     if(count1 > count2)
                //     {
                //         Map.Entry<String, info> temp = entriesArr.get(i);
                //         entriesArr.set(i , entriesArr.get(j) );
                //         entriesArr.set(j, temp);
                //     }
                // }
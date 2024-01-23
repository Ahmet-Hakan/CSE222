import java.util.LinkedHashMap;               
import java.util.ArrayList;                 
import java.util.Map;                   

/**
 * The MergeSort class represents a merge sort algorithm for sorting a myMap object.
 * The class provides methods to create a sorted myMap object from an input myMap object.
 */
public class MergeSort 
{
    myMap orginalMap;
    myMap sortedMap;

    /**
 * Constructs a new MergeSort object from the given myMap object.
 * The input myMap object is sorted using the merge sort algorithm.
 * @param map the input myMap object
 */
    public MergeSort(myMap map)
    {
        orginalMap = map;
        LinkedHashMap <String, info> temp= mergeSort (orginalMap.getMap());
        sortedMap = new myMap( temp);
    }

    /**
 * Sorts the given LinkedHashMap using the merge sort algorithm.
 * @param map the input LinkedHashMap
 * @return a new LinkedHashMap that is sorted
 */
    private LinkedHashMap <String, info> mergeSort(LinkedHashMap <String, info> map)
    {
        if(map.size() > 1)
        {
            int halfsize = map.size() /2;
            LinkedHashMap<String, info> leftMap = new LinkedHashMap<>(halfsize);
            LinkedHashMap<String, info> rightMap = new LinkedHashMap<>(map.size()- halfsize);
            
            int index =0;
            for(String a: map.keySet() )
            {
                if(index<halfsize)
                {
                    leftMap.put( a ,map.get(a) );
                }else
                rightMap.put( a ,map.get(a));
                index ++;
            }
            
            leftMap=mergeSort(leftMap);
            rightMap =mergeSort(rightMap);

            return merge(leftMap, rightMap);
        }
        return new LinkedHashMap<>(map);
    }

    //Problem solving for merge method: using entry class to acsses entries

    /**
 * Merges two sorted LinkedHashMaps into a single sorted LinkedHashMap.
 * @param left the first sorted LinkedHashMap
 * @param right the second sorted LinkedHashMap
 * @return a new LinkedHashMap that is the result of merging the two input LinkedHashMaps
 */
    private LinkedHashMap <String, info> merge( 
                LinkedHashMap <String, info> left, LinkedHashMap <String, info> right)
    {
        LinkedHashMap<String, info> result = new LinkedHashMap<>(left.size()+ right.size());

        int i =0, j=0;
        ArrayList < Map.Entry<String, info>> leftEntries = new ArrayList<>(left.entrySet());
        ArrayList < Map.Entry<String, info>> rightEntries = new ArrayList<>(right.entrySet());

        Map.Entry<String, info> leftEntry = leftEntries.get(0);
        Map.Entry<String, info> rightEntry = rightEntries.get(0);
        while(i<leftEntries.size() && j<rightEntries.size())
        {
            leftEntry = leftEntries.get(i);
            rightEntry = rightEntries.get(j);
            

            if( leftEntry.getValue().compareTo( rightEntry.getValue()) <= 0)
            {
                result.put(leftEntry.getKey(),leftEntry.getValue() );
                i++;
            }
            else
            {
                result.put(rightEntry.getKey(),rightEntry.getValue() );
                j++;
            }

            
        }

        while(i<leftEntries.size())
        {
            leftEntry = leftEntries.get(i++);
            result.put(leftEntry.getKey(),leftEntry.getValue() );
        }

        while(j<rightEntries.size())
        {
            rightEntry = rightEntries.get(j++);
            result.put(rightEntry.getKey(),rightEntry.getValue() );
        }

        return result;
    }

    /**
     * Display the sorted map to screen
     */
    public void display()
    {
        System.out.println(sortedMap);
    }
}

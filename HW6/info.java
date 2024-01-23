import java.util.ArrayList;
/**
 * The info class represents a data structure that stores a count and a list of words.
 * The count represents the number of times the info object has been updated.
 * The words list stores the words that have been added to the info object.
 * The class provides methods to create an info object, update its count and words list,
 * retrieve its count, and compare it to another info object.
 */
public class info 
{
    int count = 0;
    ArrayList<String> words = new ArrayList<String>();
    
    /**
 * Constructs a new info object with the given string as its first word.
 * The count is initialized to 1.
 * @param str the first word
 */
    public info(String str )
    {
        count =1;
        words.add(str);
    }

    /**
 * Updates this info object by incrementing its count and adding the given string to its words list.
 * @param str the word to add
 */
    public void update(String str)
    {
        count ++;
        words.add(str);
    }
    
    /**
 * Returns the count of this info object.
 * @return the count of this info object
 */
    public int getCount()
    {
        return count;
    }

    /**
 * Returns a string representation of this info object.
 * The string representation consists of the count and words list,
 * formatted as "Count: count - Words: [word1, word2, ...]".
 * @return a string representation of this info object
 */
    @Override
    public String toString() 
    {
        StringBuilder myBuilder = new StringBuilder();
        myBuilder.append(" Count: ");
        myBuilder.append(count);
        myBuilder.append(" - Words: ");
        myBuilder.append(words.toString());
        return myBuilder.toString();     
    }

    /**
 * Compares this info object to another info object based on their counts.
 * Returns a negative integer, zero, or a positive integer if this info object's count
 * is less than, equal to, or greater than the other info object's count, respectively.
 * @param other the other info object to compare to
 * @return a negative integer, zero, or a positive integer if this info object's count
 * is less than, equal to, or greater than the other info object's count, respectively
 */
    public int compareTo(info other)
    {
        if(count < other.getCount())
        return -1;
        else if(count == other.getCount())
        return 0;
        else 
        return 1;
    }

}

import java.util.LinkedHashMap;
                
/**
 * The myMap class represents a map of characters to info objects.
 * The map is implemented using a LinkedHashMap to maintain the order of insertion.
 * The class provides methods to create a map from a given string, update the map,
 * and retrieve the map and its size.
 */
public class myMap  
{
    LinkedHashMap <String, info> map = new LinkedHashMap<String, info>();
    int mapSize =0;
    String str = "";

   /**
 * Constructs a new myMap object from the given string.
 * The string is preprocessed to remove non-letter characters and convert to lowercase.
 * The map is populated with characters from the string as keys and info objects as values.
 * @param string the input string
 * @throws Exception if the input string is null, empty, or contains no letters
 */
    public myMap(String string) throws Exception
    {
        if(string == null || string == "")
        {
            throw new Exception("Error occur. Empty String.");
        }
        if(! hasLetter(string))
        {
            throw new Exception("Error occur. String has no letter.");
        }

        //Error check completed
        this.str = preproces(string);
        String[] words= str.split(" ");

        for(String a : words)
        {
            for(int k=0; k< a.length(); k++ )
            {
                char c = a.charAt(k); 
                if( map.get(Character.toString(c)) == null )
                {
                    map.put(Character.toString(c), new info(a));
                }
                else
                {
                    //TODO UPDATE
                    map.get(Character.toString(c)).update(a);
                }
            }
        }

        mapSize = map.size();
    }

    /**
    * Constructs a new myMap object from the given map.
    * @param map the input map
    */
    public myMap(LinkedHashMap <String, info> map)
    {
        this.map = map;
        mapSize = map.size();
    }

    /**
 * Returns a string representation of this myMap object.
 * The string representation consists of a list of key-value mappings,
 * where each mapping is represented as "Letter: key value".
 * @return a string representation of this myMap object
 */
    @Override
    public String toString() 
    {
        StringBuilder myBuilder = new StringBuilder();
        for(String a: map.keySet() )
        {
            myBuilder.append("Letter: ");
            myBuilder.append(a);
            myBuilder.append(" ");
            myBuilder.append(map.get(a));
            myBuilder.append("\n");
        }
        return myBuilder.toString();    
    }

    /**
 * Displays the preprocessed string and the contents of the map.
 */
    public void display()
    {
        System.out.println("Preproced String:\t" + str);
        System.out.println(this);
    }

    /**
 * Returns a copy of the map.
 * @return a copy of the map
 */
    public LinkedHashMap <String, info> getMap()
    {
        return new LinkedHashMap<>(map);
    }
    
    /**
 * Returns the preprocessed string.
 * @return the preprocessed string
 */
    public String getStr()
    {
        return str;
    }

/**
 * Preprocesses the given string by removing non-letter characters and converting to lowercase.
 * @param string the input string
 * @return the preprocessed string
 */
    private  String preproces(String string)
     {
        StringBuilder myBuilder = new StringBuilder();
        Character tempC;
        for(int i=0; i < string.length(); i++)
        {
            tempC = string.charAt(i);
            if( Character.isLetter(tempC) || Character.isSpaceChar(tempC))
            {
                myBuilder.append( Character.toLowerCase(tempC));
            }
        }
        return myBuilder.toString(); //.toLowerCase
    }

    /**
 * Returns true if the given string contains at least one letter character.
 * @param string the input string
 * @return true if the given string contains at least one letter character
 */
    private  boolean hasLetter(String string) 
    {
        char c;

        for(int i=0; i < string.length(); i++)
        {
            c = string.charAt(i);
            if(Character.isLetter(c) )
            {
               return true;
            }
        }
        return false;
    }
    
   }
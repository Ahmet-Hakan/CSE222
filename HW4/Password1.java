import java.util.Stack;

public class Password1
{
    private String password1;
    private boolean validState = false;

    /**
     * no parameter cons. assign random valids
     */
    public Password1()
    {
        password1 = "[(abacaba)]";
        validState = true;
    }

    /**
     * All test condiitons applys. 
     * Test Cases : Balanced , num brackets, username spirit, palindrome
     * All cases are succesfull, validState of password1 is true
     * @param username  username to check validty of password 
     * @param password1 to be checked validty password
     */
    public Password1(String username, String password1)
    {
        if( hasBrackets(password1) && hasLetters(password1) && hasMinChar(password1) 
        && containsUserNameSpirit(username, password1) && isBalancedPassword(password1) && isPalindromePossible(password1))
        {
            this.password1 = password1;
            validState = true;
        }
        
    }

    /**
     * In the given string sequence, the function considers two brackets to be matching 
     * if the first bracket is an open bracket, 
     * (ex: (, {, or [), and the next bracket is a closed bracket of the same type. 
     * String cannot start with a closed bracket. There can be letters between any two brackets
     * @param password1 to check is balanced or not
     * @return if its balanced return true otherwise false
     */
    public  boolean isBalancedPassword(String password1)
    {
        Stack<Character> roundBrackets = new Stack<Character>();
        Stack<Character> squareBrackets = new Stack<Character>();
        Stack<Character> curlyBrackets = new Stack<Character>();
        try 
        {
            for(int i=0 ; i<password1.length(); i++) 
            {
                char control = password1.charAt(i);
                if(control == '(')
                roundBrackets.push(control);

                else if(control == '[')
                squareBrackets.push(control);

                else if(control == '{')
                curlyBrackets.push(control);

                else if(control == ')')
                roundBrackets.pop();

                else if(control == ']')
                squareBrackets.pop();
            
                else if(control == '}')
                curlyBrackets.pop();
            }    
        } 
        catch (Exception ex) { 
            System.out.println("The password1 is invalid. It should be balanced.");
            return false;
        }

        if( roundBrackets.empty() && squareBrackets.empty() && curlyBrackets.empty())
        return true;
        
        //check for unclosed parantheses
        else 
        {
            System.out.println("The password1 is invalid. It should be balanced.");
            return false;
        }

    }

    /**
     * a function which checks if the string password contains at least one letter of the username
     * @param username  username to check validty of password
     * @param password1 to be checked validty password
     * @return if its contains return true otherwise false
     */
    public  boolean  containsUserNameSpirit(String username, String password1)
    {
        Stack<Character> s = new Stack<Character>();

        for(int i=0 ; i<password1.length(); i++) // fill the stacks only letters from password
        {
            char control = password1.charAt(i);
            if( Character.isLetter( control ))
            {
                s.push(control);
            }
        }

        while(! s.empty())
        {
            for(int i=0 ; i<username.length(); i++) //search the username 
            {
                if(s.peek() == username.charAt(i))
                return true;                
            }
            s.pop();
        }
        System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
        return false;
    }

    
    public boolean isPalindromePossible(String password1) {
        password1 = password1.replaceAll("[\\{\\}\\(\\)\\[\\]]", "");
        if(isPalindromePossible(password1, 0, 0)) 
        return true;
        else
        {
            System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
            return false;
        }
    }
    
    /**
     * In the given string sequence, the function considers if it is possible to obtain a palindrome by rearranging the letters in the string.
     *  The function ignores the brackets in the string while computing the function. 
     * While converting the string to palindrome
     * @param password1 to be checked validty password
     * @return if its palindrome return true otherwise false
     */
    private boolean isPalindromePossible(String password1,  int index, int oddCount) {
        if(oddCount > 1 )
        {
            return false;
        }

        if (index == password1.length())
        {
            return true;
        }

        int count =0; 
        for(int i = 0; i< password1.length() ;i++)
        {
            if( password1.charAt(index) == password1.charAt(i))
            {
                count ++;
            }
            
        }

        if( (count )%2 == 1)
        oddCount ++;
    
        return isPalindromePossible(password1,  index + 1, oddCount);
        
    }

    /**
     * checks has brackets
     * @param password1 to be checked validty password
     * @return has brackets return true otherwise false
     */
    private boolean hasBrackets(String password1)
    {
        int numBrackets =0;
        for(int i=0 ; i<password1.length(); i++) 
        {
            char control = password1.charAt(i);
            if(control == '(' || control == '[' || control == '{' || 
            control == ')' || control == ']' || control == '}' )
            ++ numBrackets;
        }
        
        if(numBrackets < 2)
        {
        System.out.println("The password1 is invalid. It should have at least 2 brackets.");
        return false;
        }
        else
        return true;
            
    }

    /**
     * checck atleast eight char
     * @param password1 to be checked validty password
     * @return has at least 8 char return true othewise false
     */
    private boolean hasMinChar( String password1)
    {
        if(password1.length() < 8 )
        {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return false;
        }
        else
        return true;
    }

    /**
     * checks has letters
     * @param password1 to be checked validty password
     * @return has letters true otherwise false
     */
    private boolean hasLetters( String password1)
    {
        for(int i=0 ; i<password1.length(); i++) 
        {
            char control = password1.charAt(i);
            if(control >64 && control < 91 || control >96 && control < 123)
            {
                return true;
            }
        }
        System.out.println("The password1 is invalid. It should have letters too.");
        return false;

    }

    /**
     * getter for valis State
     * @return valid State is return true 
     */
    public boolean getvalidState()
    {
        return validState;
    }
}
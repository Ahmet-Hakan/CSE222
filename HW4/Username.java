public class Username
{
    private String username;
    private boolean validState = false;

    /**
     * assign valid name
     */
    public Username()
    {
        username = "a";
        validState = true;
    }


    /**
     * constructor chechk all validty conditons
     * @param username to check  validty
     */
    Username(String username)
    {
        if(username == null || username.equals(""))
        System.out.println("The username is invalid. It should have at least 1 character.");

        else
        {
            if(checkLetters(username) )
            {
                this.username = username;
                validState = true;
            }
            else
            System.out.println("The username is invalid. It should have letters only.");
        }
        
    }

    public String getUsername() 
    {
        return username;    
    }

    /**
     * a function which checks if it contains only letters, and the minimum length is 1.
     * @param str to check has letters
     * @return has only letters return true oterwisr false
     */
    public boolean checkLetters(String str)
    {
        if(str == null || str.equals(""))
        return true;

        if(! Character.isLetter( str.charAt(0) ) && str.charAt(0) != ' ')
        return false;
        
        else
        return checkLetters(str.substring(1));
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
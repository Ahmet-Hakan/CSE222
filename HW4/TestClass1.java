class TestClass1
{
    public static void main(String[] args) 
    {
        int [] denominations = {4,29,17};
        Username user = new Username("a");
        Password1 pass1 = new Password1(user.getUsername(), "[rac()ecar]");
        Password2 pass2 ; 
        
        //Testing Usernames
        String[] usernames = {"", "sibel1"};
        for(int i =0 ; i< usernames.length ; i++)
        {
            System.out.println("Username: " + usernames[i] +"\tPassword1: " + "[rac()ecar]" +"\tPassword2: "+ 74);
            user = new Username(usernames[i]);
        }
        
        user = new Username("a");//valid name
        // Passwords1 each Test Case
        String[] myStrings = {"pass[]","abcdabcd","[[[[]]]]","[no](no)","[rac()ecar]]","[rac()ecars]"};
        for(int i =0 ; i< myStrings.length ; i++)
        {
           System.out.println("Username: " + user.getUsername() +"\tPassword1: " + myStrings[i] +"\tPassword2: "+ 74);
           pass1 = new Password1(user.getUsername(), myStrings[i]);
        }
        
        pass1 = new Password1(user.getUsername(), "[rac()ecar]");//valid pass1
        // Testing Password2
        int[] a = {5,35};
        for(int i =0 ; i< a.length ; i++)
        {
            System.out.println("Username: a"  +"\tPassword1: " + "[rac()ecar]" +"\tPassword2: "+ a[i]);
            pass2 = new Password2(a[i],denominations);
        }

        System.out.println("Username: a"  +"\tPassword1: " + "[rac()ecar]" +"\tPassword2: "+ 75);
        pass2 = new Password2(75,denominations);

        if(user.getvalidState() && pass1.getvalidState() && pass2.getvalidState())
        System.out.println("The username and passwords are valid. The door is opening, please wait..");

    }

      
}
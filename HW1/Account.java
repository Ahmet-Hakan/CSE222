package homework1;
/**
 * Account class impelmented for reperesenting a socaial media platform.
 * Account class has all the function in this platform.
 * @version 1.0
 *@author Ahmet Hakan Sevinc 
 */
public class Account 
{
    private int accountID;
    private String username;
    private String birthdate;
    private String location;
    private Post[] posts= new Post[20];
    private Message[] message = new Message[20];
    private Account[] followings = new Account[20];
    private Account[] followers = new Account[20];
    private Account[] blocks = new Account[20];

    private int currentViewProflieID = -1;
    private int cuurentViewPostID  = -1;
    private int numBlocks = 0;
    private int numPost = 0;
    private int numMessage = 0;
    private int numFollowings = 0;
    private int numFollowers = 0;
    private boolean loginState = false;
    
    /**
     * Constructor for Account class. It has four argument.
     * @param id specifies user id
     * @param name specifies user name
     * @param date specifies birthdate
     * @param loc specifies location 
     */
    Account (int id,String name, String date, String loc)
    {
        accountID = id;
        username = name;
        birthdate = date;
        location = loc;
    }



    /**
     * getter for Account Identical number
     * @return accountID member of class
     */
    public int getAccountID(){return accountID;}

    /**
     * getter for username member
     * @return username
     */
    public String  getUsername()
    {
        return username;
    }

    /**
     * getter for location member
     * @return location of user
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * getter for birthdate member
     * @return birth date of user
     */
    public String getBrithday()
    {
        return birthdate;
    }

    /**
     * getter for numFollowers member
     * @return number of Followers
     */
    public int getNumFollowers()
    {
        return numFollowers;
    }

    /**
     * getter for numFollowings member
     * @return number of Followings
     */
    public int getNumFollowings()
    {
        return numFollowings;
    }

    /**
     * getter for followings member
     * @return following accounts
     */
    public Account[] getFollowings()
    {
        return followings;
    }

    /**
     * getter for followers member 
     * @return followers accounts
     */
    public Account[] getFollowers()
    {
        return followers;
    }

    /**
     * getter for blocks member
     * @return blocked accounts
     */
    public Account[] getBlocks()
    {
        return blocks;
    }

    /**
     * getter for message member
     * @return messages of user
     */
    public Message[] getMessages()
    {
        return message;
    }

    /**
     * getter for numPost
     * @return number of Posts
     */
    public int getNumPost()
    {
        return numPost;
    }
    
    /**
     * getter for numMessage member
     * @return number of messages
     */
    public int getNumMessage()
    {
        return numMessage;
    }

    /**
     * getter for loginState member 
     * @return Login State of user
     */
    public boolean getLoginState()
    {
        return loginState;
    }

    /**
     * getter for posts member
     * @return  Posts of user
     */
    public Post[] getPosts()
    {
        return posts;
    }
    
    /**
     * increment one number of messages
     */
    public void incrementNumMessage()
    {
        ++ numMessage;
    }

   


    
    /**
     * Check login State of user. If there is any user login other than user given parameter, Login is unsuccess
     * there is no issue , login is success
     * @param users Neccasry for check other accounts is login state 
     * @return loginState
     */
    public boolean Login(Account[] users)
    {
        if(loginState == true)
        {
            System.out.println("!!! Already login !!!");
        }
        else if(!checkAnyLogin(users))
        {
            loginState = true;
        }
        else
        {
            System.out.println("!!! Login was unsuccess !!!");
            loginState = false;
        }

        return loginState;
    }

    /**
     * logout from account,If Account is login
     * @return operation success
     */
    public boolean Logout()
    {
        if(loginState == false)
        {
            System.out.println("!!! Account is already logout !!!");
        }
        loginState = false;
        return !(loginState);
    }

    private boolean checkAnyLogin(Account[] users)
    {
        for(int i=0 ; i<users.length ; i++ )
        {
            if(users[i].getLoginState() == true)
            {
                return true;
            }
        }
        return false;
        
    }

    
    /**
     * If account is login, adds new Post 
     * @param postID postID of post
     * @param content content of post
     */
    public void addPost(int postID, String content) 
    {
        if(loginState == true)
        {
            posts[postID] = new Post(postID, accountID, content);
            ++numPost;
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
        
    }
    /**
     * If account is login, folow given account 
     * @param account account to follow
     */
    public void follow(Account account) 
    {
        if(loginState == true)
        {
            followings[numFollowings] = account;
            account.addFollwers(this);
            ++ numFollowings;
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
    }

    private void addFollwers(Account account)
    {
        followers[numFollowers] = account;
        ++ numFollowers;
    }

    private boolean folowCheck(String userName)
    {
        for(int i =0; i< numFollowings; i++ )
        {
            if(getFollowings()[i].getUsername() == userName)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * If account is login and account that to view is not block this account,
     * view given account  
     * @param account account to view
     */
    public void view(Account account)
    {
        if( account.checkBloceked(this)  )
        {
            System.out.println("Can't view this profile.\n"+account.getUsername() + " blocked to  you.");
            return ;  
        }

        else if(loginState == true)
        {
            System.out.println("User ID:  " + account.getAccountID());
            System.out.println("Username: " + account.getUsername());
            System.out.println("Location: " + account.getLocation());
            System.out.println("Brithdate: " + account.getBrithday());
            System.out.print(account.getUsername() + " is following " +account.getNumFollowings() +
            " account(s) and has "+ account.getNumFollowers()+" follower(s).\n" );

            if(account.getNumFollowers() > 0 )
            {
                System.out.print(account.getUsername() + " has followers ");
                for(int i=0; i<account.getNumFollowers(); i++)
                System.out.print(account.getFollowers()[i].getUsername() + " ");
            }

            if(account.getNumFollowings() > 0 )
            {
                System.out.print( account.getUsername() + " is following ");
                for(int i=0; i<account.getNumFollowings(); i++)
                System.out.print(account.getFollowings()[i].getUsername() + " ");
            }
            System.out.println("\n"+ account.getUsername()+ " has " + account.getNumPost() + " posts");

            currentViewProflieID = account.getAccountID();
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
    }

    /**
     * If account is login and view the given account profile, Views to post 
     * @param account account that posted
     * @param postID postID to view
     */
    public  void viewPost(Account account, int postID)
    {
        if(loginState == true )
        {
            if( account.getAccountID() == currentViewProflieID)
            {
                    System.out.println( account.getPosts()[postID]);
                    cuurentViewPostID = postID;
            }
            else
            {
                System.out.println("Have to view " + account.getUsername() + " profile.");
            }
        }
        else
        {
            System.out.println("Have to be login.");
        }
    }

    /**
     * If account is login and view the given post, likes the post 
     * @param account account that posted
     * @param postID postID to like
     */
    public void addLike(Account account, int postID) 
    {
        if(loginState == true)
        {
            if( account.getAccountID() == currentViewProflieID && postID == cuurentViewPostID )
            {
                int index = account.getPosts()[postID].getNumLike();
                account.getPosts()[postID].getLike()[ index ] = 
                new Like(index,accountID, postID);
                System.out.println("Post liking");
                account.getPosts()[postID].incrementNUMLİke(postID);
            }
            else
            {
                System.out.println("Have to view " + account.getUsername() + " profile's postID: " + postID);
            }
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
        
    }

    /**
     * If account is login and view the given post, adds a commnet
     * @param account account that posted
     * @param postID postID to add comment
     * @param content content of comment
     */
    public void addComment (Account account, int postID, String content )
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }
        
        if(account.getAccountID() == currentViewProflieID && postID == cuurentViewPostID)
        {
            int index = account.getPosts()[postID].getNumComment();
            account.getPosts()[postID].getComment()[ index ] = 
            new Comment(index,accountID, postID, content);
            System.out.println("Commnet added: " + content);
            account.getPosts()[postID].incrementNUMComment();
        }
        else
        {
            System.out.println("Have to view " + account.getUsername() + " profile's postID: " + postID);
        }
    }

    /**
     * If account is login and account that to view is not block this account and follow the account,
     * sends a message
     * @param account account that wanted to message
     * @param content content of message
     */
    public void sendMessage(Account account, String content)
    {
        if( account.checkBloceked(this)  )
        {
            System.out.println("Can't send to this profile.\n"+account.getUsername() + " blocked to  you.");
            return ;  
        }
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        if(folowCheck(account.getUsername()) )
        {
            message[numMessage] = new Message(numMessage,accountID,account.getAccountID(),content);
            account.getMessages()[account.getNumMessage()] =  message[numMessage];
            ++numMessage;
            account.incrementNumMessage();
        }
        else
        {
            System.out.println("Have to folow " + account.getUsername());

        }
        
    }

    /**
     * view Inbox message if it is there any
     * @param users accounts was messaged
     */
    public void viewInbox(Account[] users)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i < numMessage; i++)
        {
            System.out.printf("\nViewing inbox...\n");
            if(message[i].getReseverID() == accountID)
            {
                System.out.println("Message ID: " + message[i].getMesaageID());
                System.out.println("From: " + users[message[i].getSenderID()].getUsername());
                System.out.println("TO: " + username);
                System.out.println("Message: " + message[i].getContent());
            }
        }
    }

    /**
     * view Outbox message if it is there any
     * @param users accounts was messaged
     */
    public void viewOutbox(Account[] users)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i < numMessage; i++)
        {
            System.out.printf("\nViewing outbox...\n");
            if(message[i].getSenderID() == accountID)
            {
                System.out.println("Message ID: " + message[i].getMesaageID());
                System.out.println("From: " + username);
                System.out.println("TO: " + users[message[i].getReseverID()].getUsername());
                System.out.println("Message: " + message[i].getContent());
            }
        }

    }

    /**
     * If account is login ,prints to screen  number of message in ınbox  
     */
    public void checkNumInbox()
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        int num = 0;
        for(int i=0; i < numMessage; i++)
        {
            if(message[i].getReseverID() == accountID)
            num++;
        }
        System.out.println("Checking Inbox...");
        System.out.println("There is/are " + num + " message(s) in the inbox.");

    }

    /**
     * If account is login ,prints to screen  number of message in outbox
     */
    public void checkNumOutbox()
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        int num = 0;
        for(int i=0; i < numMessage; i++)
        {
            if(message[i].getSenderID() == accountID)
            ++num;
        }
        System.out.println("Checking Outbox...");
        System.out.println("There is/are " + num + " message(s) in the outbox.");

    }

    /**
     * If account is login, views interactions of the given account
     * @param account account that view interaction
     * @param users accounts that with inreraction
     */
    public void viewInteraction(Account account, Account[] users )
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i<account.getNumPost() ; i++)
        {

            System.out.println( account.getPosts()[i]);
            if(account.getPosts()[i].getNumLike() > 0)
            {
                System.out.printf("The post was liked by the following account(s): \n");
                for(int j=0; j < account.getPosts()[i].getNumLike(); j++ )
                System.out.print( 
                users[account.getPosts()[i].getLike()[j].getAccountID()].getUsername() + " "    );
            }
            else
            {
                System.out.println("The post has no like");
            }
            
            if(account.getPosts()[i].getNumComment() > 0)
            {
                System.out.printf("\nThe post has %d comment(s)... \n",account.getPosts()[i].getNumComment());
                for(int j=0; j < account.getPosts()[i].getNumComment(); j++ )
                System.out.printf("Comment %d: '%s' said '%s' \n" 
                , j, users[account.getPosts()[i].getComment()[i].getAccountID()].getUsername() ,
                account.getPosts()[i].getComment()[j].getContent());
            }
            else
            {
                System.out.println("The post has no commnet");
            }
           
            
        }
        

    }

    /**
     * If account is login, blocks the given account
     * @param account account that want to block
     */
    public void block(Account account)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }
        blocks[numBlocks] = account ;
        ++numBlocks;
    }

    private boolean checkBloceked(Account account)
    {
        for(int i=0; i< numBlocks; i++)
        {
            if(blocks[i].getAccountID() == account.getAccountID() )
            {
                return true;
            }
        }
        return false;
    }
}
package homework3a;
import java.util.ArrayList;
public class Account 
{
    private int accountID;
    private String username;
    private String birthdate;
    private String location;
    private ArrayList <Post> posts;
    private ArrayList <Message> message;
    private ArrayList <Account> followings;
    private ArrayList <Account>followers;
    private ArrayList <Account> blocks;
    private String history;

    private int currentViewProflieID = -1;
    private boolean loginState = false;

    Account (int id,String name, String date, String loc)
    {
        accountID = id;
        username = name;
        birthdate = date;
        location = loc;
        history = "History of " + username;
        posts = new ArrayList<Post>();
        message = new ArrayList<Message>();
        followings = new ArrayList<Account>();
        followers = new ArrayList<Account>();
        blocks = new ArrayList<Account>();
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
     * getter for loginState member 
     * @return Login State of user
     */
    public boolean getLoginState()
    {
        return loginState;
    }

    /**
     * getter for followers account list
     * @return Followers accounts
     */
    public ArrayList <Account> getFollowers()
    {
        return followers;
    }

    /**
     * getter for followings account list
     * @return Followings accounts
     */
    public ArrayList <Account> getFollowings()
    {
        return followings;
    }

    /**
     * getter for Posts list
     * @return shared Posts
     */
    public ArrayList <Post> getPosts()
    {
        return posts;
    }

    /**
     * getter for Message list
     * @return all message
     */
    public ArrayList <Message> getMessages()
    {
        return message;
    }
 
   

    /**
     * Check login State of user. If there is any user login other than user given parameter, Login is unsuccess
     * there is no issue , login is success
     * @param users Neccasry for check other accounts is login state 
     * @return loginState
     */
    public boolean Login(ArrayList <Account> users)
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

    private boolean checkAnyLogin(ArrayList <Account> users)
    {
        for(int i=0 ; i<users.size() ; i++ )
        {
            if(users.get(i).getLoginState() == true)
            {
                return true;
            }
        }
        return false;
        
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

    /**
     * If account is login, folow given account.
     * @param account account to follow
     */
    public void follow(Account account) 
    {
        if(loginState == true)
        {
            if(account.equals(this))
            {
                System.out.println("The account can not  follow itselfs");
                return;
            }

            if( account.checkBloceked(this)  )
            {
                System.out.println("Can't follow this profile.\n"+account.getUsername() + " blocked to  you.");
                return ;  
            }

            if(checkBloceked(account))
            {
                System.out.println("Can't follow this profile.\n" + " you blocked to  ."+account.getUsername() );
                return ;
            }
            

            if(folowCheck(account.getUsername()))
            System.out.println("The account is already following");
            else
            {
                followings.add(account);
                account.addFollwers(this);
                addtoHistory("\nThe account" + account.getUsername() + "is followed."  );
            }
            
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
    }

    /**
     * If users logins, unfollowed the given account  
     * @param account the account which will be unfollowed
     */
    public void unfollow(Account account)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        if(folowCheck(account.getUsername() ))
        {
            followings.remove(followings.indexOf(account)) ;
            account.removeFollowers(this);
            addtoHistory("\nThe account " + account.getUsername() + " is unfollowed."  );
        }
    }

    private void removeFollowers(Account account)
    {
        followers.remove( followers.indexOf( account));
    }

    private void addFollwers(Account account)
    {
        followers.add(account);
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
            posts.add(postID, new Post(postID, accountID, content) );
            addtoHistory("\nThe Post:" + content + " is added.");
        }
        else
        {
            System.out.println("Have to be login " + username);        
        }
        
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

        if(checkBloceked(account))
        {
            System.out.println("Can't view this profile.\n" + " you blocked to  ."+account.getUsername() );
            return ;
        }

        else if(loginState == true)
        {
            System.out.println("User ID:  " + account.getAccountID());
            System.out.println("Username: " + account.getUsername());
            System.out.println("Location: " + account.getLocation());
            System.out.println("Brithdate: " + account.getBrithday());
            System.out.print(account.getUsername() + " is following " +account.getFollowings().size() +
            " account(s) and has "+ account.getFollowers().size()+" follower(s).\n" );

            if(account.getFollowers().size() > 0 )
            {
                System.out.print(account.getUsername() + " has followers ");
                for(int i=0; i<account.getFollowers().size(); i++)
                System.out.print(account.getFollowers().get(i).getUsername() + " ");
            }

            if(account.getFollowings().size() > 0 )
            {
                System.out.print( account.getUsername() + " is following ");
                for(int i=0; i<account.getFollowings().size(); i++)
                System.out.print(account.getFollowings().get(i).getUsername() + " ");
            }
            System.out.println("\n"+ account.getUsername()+ " has " + account.getPosts().size() + " posts");

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
                    System.out.println( account.getPosts().get(postID));
                    
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
     * If account is login and view the given account, likes the post 
     * @param account account that posted
     * @param postID postID to like
     */
    public void addLike(Account account, int postID) 
    {
        if(loginState == true)
        {
            if( account.getAccountID() == currentViewProflieID  )
            {
                if(checkLiked(account, postID))
                System.out.println("The post is already liked.");
                else
                {
                    int index = account.getPosts().get(postID).getLike().size();
                    account.getPosts().get(postID).getLike().add( new Like(index,accountID, postID));
                    System.out.println("Post liking");
                    addtoHistory("\nThe post of " + account.getUsername() + " is liked.");
                }
            }
            else
            {
                System.out.println("Have to view account of " + account.getUsername());
            }
        }
        else
        {
            System.out.println("Have to be login " + username);
        }
        
    }

    /**
     * If account is login and view the given account, unlikes the post
     * @param account owner of post
     * @param postID  post which is wanted to be unliked
     */
    public void unlike(Account account, int postID)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        if( account.getAccountID() == currentViewProflieID  )
        {       
            for(Like like : account.getPosts().get(postID).getLike())
            {
                if(like.getAccountID() == accountID)
                {
                    account.getPosts().get(postID).getLike().remove(like);
                    System.out.println("Unlike post");
                    addtoHistory("\nThe post of " + account.getUsername() + " is unliked.");
                    return ;
                }
            } 
            System.out.println("!!!!!! The post wasn't liked. SO it can not be unliked !!!!!!");  
            
        }
        else
        {
            System.out.println("Have to view " + account.getUsername() + " profile's postID: " + postID);
        }

    }

    /**
     * Checking the post is liked or nor
     * @param account
     * @param postID
     * @return if the post is liked return true, otherwise false
     */
    private boolean checkLiked(Account account, int postID)
    {
        for(Like like : account.getPosts().get(postID).getLike())
        {
            if(like.getAccountID() == accountID)
            return true;
        }
        return false;
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
        
        if(account.getAccountID() == currentViewProflieID )
        {
            int index = account.getPosts().get(postID).getComment().size();
            account.getPosts().get(postID).getComment().add(index,   
            new Comment(index,accountID, postID, content) );
            System.out.println("Commnet added: " + content);
            addtoHistory("\n The post of " + account.getUsername() + " is commented.");
        }
        else
        {
            System.out.println("Have to view " + account.getUsername() + " profile's postID: " + postID);
        }
    }

    /**
     * Uncomment a post if owner a post is viewed
     * If post commented uncomment
     * @param account owner of the post
     * @param postID post Whose comment is deleted
     */
    public void uncomment(Account account, int postID)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        if(account.getAccountID() == currentViewProflieID )
        {
            for(Comment comment : account.getPosts().get(postID).getComment())
            {
                if(comment.getAccountID() == accountID)
                {
                    account.getPosts().get(postID).getComment().remove(comment);
                    System.out.println("Comment is deleted");
                    addtoHistory("\n The post of " + account.getUsername() + " is uncommented.");
                    return;
                }
                
            }
            System.out.println("!!!!!! The post wasn't commented. SO it can not be uncomment !!!!!!");  
        }else
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
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        if(checkBloceked(account))
        {
            System.out.println("Can't send message to this profile.\n" + " you blocked to  ."+account.getUsername() );
            return ;
        }

        if( account.checkBloceked(this)  )
        {
            System.out.println("Can't send message to this profile.\n"+account.getUsername() + " blocked to  you.");
            return ;  
        }
       

        if(folowCheck(account.getUsername()) )
        {
            message.add(new Message( message.size(),accountID,account.getAccountID(),content));
            account.getMessages().add( message.get(message.size() -1 ) );
            addtoHistory("\n A message is sended to " + account.getUsername());
        }
        else
        {
            System.out.println("Have to folow " + account.getUsername());

        }
        
    }

    /**
     * Check account following or not
     * @param userName username of following account
     * @return if account followings return true, otherwise false 
     */
    private boolean folowCheck(String userName)
    {
        for(int i =0; i< getFollowings().size(); i++ )
        {
            if(getFollowings().get(i).getUsername() == userName)
            {
                return true;
            }
        }
        return false;
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
        blocks.add(account);
        addtoHistory("\n The account " + account.getUsername() + " is blocked");
    }

    /**
     * If account is blocked, remove the account from blocks list
     * @param account account which unblocked 
     */
    public void unblock(Account account)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }
        if(checkBloceked(account))
        {
            blocks.remove( blocks.indexOf(account));
            addtoHistory("\n The account " + account.getUsername() + " is unblocked");
        }
        else
        System.out.println("!!!!!! The account " + account.getUsername() + "is not blocked.SO it can not be unblocked");
    }

    /**
     * Check the account is blocked. If it blocked return true, otherwise false
     * @param account is searched in block list
     * @return
     */
    private boolean checkBloceked(Account account)
    {
        for(int i=0; i< blocks.size(); i++)
        {
            if(blocks.get(i).getAccountID() == account.getAccountID() )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * view Inbox message if it is there any
     * @param users accounts was messaged
     */
    public void viewInbox(ArrayList <Account> users)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i < message.size(); i++)
        {
            System.out.printf("\nViewing inbox...\n");
            if(message.get(i).getReseverID() == accountID)
            {
                System.out.println("Message ID: " + message.get(i).getMesaageID());
                System.out.println("From: " + users.get(message.get(i).getSenderID()).getUsername());
                System.out.println("TO: " + username);
                System.out.println("Message: " + message.get(i).getContent());
            }
        }
    }

    /**
     * view Outbox message if it is there any
     * @param users accounts was messaged
     */
    public void viewOutbox(ArrayList <Account> users)
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i < message.size(); i++)
        {
            System.out.printf("\nViewing outbox...\n");
            if(message.get(i).getSenderID() == accountID)
            {
                System.out.println("Message ID: " + message.get(i).getMesaageID());
                System.out.println("From: " + username);
                System.out.println("TO: " + users.get(message.get(i).getReseverID()).getUsername());
                System.out.println("Message: " + message.get(i).getContent());
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
        for(int i=0; i < message.size(); i++)
        {
            if(message.get(i).getReseverID() == accountID)
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
        for(int i=0; i < message.size(); i++)
        {
            if(message.get(i).getSenderID() == accountID)
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
    public void viewInteraction(Account account,ArrayList <Account> users )
    {
        if(loginState != true)
        {
            System.out.println("Have to be login " + username);
            return ;
        }

        for(int i=0; i<account.getPosts().size() ; i++)
        {

            System.out.println( account.getPosts().get(i));
            if(account.getPosts().get(i).getLike().size() > 0)
            {
                System.out.printf("The post was liked by the following account(s): \n");
                for(int j=0; j < account.getPosts().get(i).getLike().size(); j++ )
                System.out.print( 
                users.get(account.getPosts().get(i).getLike().get(j).getAccountID())
                .getUsername() + " "    );
            }
            else
            {
                System.out.println("The post has no like");
            }
            
            if(account.getPosts().get(i).getComment().size() > 0)
            {
                System.out.printf("\nThe post has %d comment(s)... \n",account.getPosts().get(i).getComment().size());
                for(int j=0; j < account.getPosts().get(i).getComment().size(); j++ )
                System.out.printf("Comment %d: '%s' said '%s' \n" 
                , j, users.get(account.getPosts().get(i).getComment().get(j).getAccountID())
                .getUsername() ,
                account.getPosts().get(i).getComment().get(j).getContent());
            }
            else
            {
                System.out.println("The post has no commnet");
            }
           
            
        }
        

    }

    /**
     * This method print the screen users history. Starting from account created
     */
    public void showHistory() 
    {
        System.out.println(history);     
    }

    /**
     * updating history
     * @param event the event will be added to history
     */
    private void addtoHistory( String event)
    {
        history += event;
    }
}


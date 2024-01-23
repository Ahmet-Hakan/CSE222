package homework3a;
/**
 * The Post class is implemented for controling posts.
 * 
 * @version 1.0
 *@author Ahmet Hakan Sevinc 
 */
import java.util.ArrayList;


public class Post {
    private int  postID;
    private int accountID;
    private ArrayList <Like> like;
    private ArrayList <Comment> comment ;
    private String  content;


    /**
     *  Constructor of Post Class
     * @param postID specifies postID member
     * @param accountID specifies accountID member
     * @param content specifies content member
     */
    Post(int postID,int accountID, String content)
    {
        this.accountID = accountID;
        this.postID = postID;
        this.content = content;
        like = new ArrayList <Like> (5);
        comment = new ArrayList <Comment> (5);
    }

    /**
     * getter for postID
     * @return ID of post
     */
    public int  getPostID() 
    {
        return postID;    
    }

    /**
     * getter for accountID
     * @return accountID of post
     */
    public int  getAccountID() 
    {
        return accountID;    
    }
    
    /**
     * getter for content member 
     * @return content of post
     */
    public String  getContent() 
    {
        return content;
    }

    /**
     * getter for like member
     * @return likes of post
     */
    public ArrayList <Like> getLike() 
    {
        return like;   
    }

    /**
     * getter for comment member
     * @return comments of post
     */
    public ArrayList <Comment> getComment() 
    {
        return comment;
    }
    
   

    /**
     * toString method of Post Class 
     */
    public String toString() 
    {
        return "postID " + postID + " : " + content ;
        
    }
}

 
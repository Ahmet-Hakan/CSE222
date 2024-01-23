package homework3b;

/**
 * The Post class is implemented for controling posts.
 * 
 * @version 1.0
 *@author Ahmet Hakan Sevinc 
 */
import java.util.LinkedList;


public class Post {
    private int  postID;
    private int accountID;
    private LinkedList <Like> like;
    private LinkedList <Comment> comment ;
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
        like = new LinkedList <Like> ();
        comment = new LinkedList <Comment> ();
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
    public LinkedList <Like> getLike() 
    {
        return like;   
    }

    /**
     * getter for comment member
     * @return comments of post
     */
    public LinkedList <Comment> getComment() 
    {
        return comment;
    }
    
    // /**
    //  * getter for numlike member
    //  * @return number of like
    //  */
    // public  int getNumLike()
    // {
    //     return numLike;
    // }

    // /**
    //  * getter for numComment member 
    //  * @return number of commnet
    //  */
    // public int getNumComment() 
    // {
    //     return numComment;    
    // }

    // /**
    //  * increment one number of comment
    //  */
    // public void incrementNUMComment()
    // {
    //     ++numComment;
    // }

    // /**
    //  * increment one number of like
    //  */
    // public void incrementNUMLİke()
    // {
    //     ++ numLike;
    // }

    /**
     * toString method of Post Class 
     */
    public String toString() 
    {
        return "postID " + postID + " : " + content ;
        
    }
}

 
package homework3b;

/**
 * The Comment class is implemeted for  making a comment to Post 
 * @version 1.0
 *@author Ahmet Hakan Sevin
 */
public class Comment extends Interaction
{
    private String content;
    /**
     * Constructor of commnet class
     * @param interactionID specifies interactionID member
     * @param accountID specifies accountID member
     * @param postID specifies postID member
     * @param content specifies content member
     */
    Comment(int interactionID, int accountID, int postID,String content)
    {
        super(interactionID, accountID, postID);
        this.content = content;
    }

    /**
     * getter for content member
     * @return content of commnet
     */
    public String getContent()
    {
        return content;
    }
}
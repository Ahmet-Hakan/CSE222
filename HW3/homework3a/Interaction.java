package homework3a;
/**
 * Interaction class is implemeted for being superclass of like and commrnt class
 * @version 1.0
 *@author Ahmet Hakan Sevinc 
 */
public class Interaction
{
    protected int interactionID;
    protected int accountID;
    protected int postID;
    
    /**
     * Constructor of Interaction class
     * @param interactionID specifies interactionID member
     * @param accountID specifies accountID member
     * @param postID specifies postID member
     */
    Interaction(int interactionID, int accountID, int postID)
    {
        this.interactionID =  interactionID;
        this.accountID = accountID;
        this.postID = postID;
    }

    /**
     *  getter for accountID member
     * @return accountID of Interaction
     */
    public int getAccountID()
    {
        return accountID;
    }

    public int compareTo(Interaction interaction){  
        if(interaction.getAccountID() == accountID)  
        return 0;  
        else if(accountID > interaction.getAccountID())  
        return 1;  
        else  
        return -1;  
        } 
    
}
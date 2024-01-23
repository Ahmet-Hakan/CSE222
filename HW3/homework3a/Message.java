package homework3a;
/**
 * Message Class is implemented for messaging between accounts 
 * @version 1.0
 *@author Ahmet Hakan Sevinc 
 */
public class Message {

    private int messageID;
    private int senderID;
    private int reseverID;
    private String content;

    /**
     * Constructor of Mesaage Class
     * @param messageID specifies messageID member
     * @param senderID specifies  senderID member
     * @param reseverID specifies  reseverID member
     * @param content specifies  content member
     */
    Message(int messageID, int senderID, int reseverID, String content)
    {
        this.messageID = messageID;
        this.senderID = senderID;
        this.reseverID = reseverID;
        this.content = content;
    }

    /**
     * getter for reseverID member
     * @return reseverID of message
     */
    public int getReseverID()
    {
        return reseverID;
    }

    /**
     * getter for MessageID  member
     * @return messageID of message
     */
    public int getMesaageID() 
    {
        return messageID;
    }

    /**
     * getter for senderID  member
     * @return senderID of message
     */
    public int getSenderID()
    {
        return senderID;
    }

    /**
     * getter for content  member
     * @return content of message
     */
    public String getContent()
    {
        return content;
    }
}

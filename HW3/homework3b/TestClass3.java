package homework3b;
import java.util.LinkedList;
class TestClass3
{
    public static void main(String[] args) 
    {
        LinkedList <Account> users = new  LinkedList <Account>();
        users.add(0, new Account(0, "sibelgulmez", "10.03.1995", "Istanbul"));
        users.add(1, new Account(1, "gizemsungu", "10.03.1995", "Istanbul"));
        users.add(2, new Account(2, "gokhankaya", "10.03.1995", "Istanbul"));

        System.out.print("STEP 1... Creating accounts...\n");
        System.out.print( "An account with username gizemsungu has been created.\n");
        System.out.print("An account with username sibelgulmez has been created.\n");
        System.out.print( "An account with username gokhankaya has been created.\n");
    
        System.out.print("STEP 2... Logging into an account (username: sibelgulmez)\n");
        users.get(0).Login(users);
    
        System.out.print("STEP 3... Sharing two post\n");
        users.get(0).addPost(0, "I like Java.");
        users.get(0).addPost(1, "Java the coffee...");
    
        System.out.print("STEP 4... Following gizemsungu and gokhankaya...\n");
        users.get(0).follow(users.get(2));
        users.get(0).follow(users.get(1));
    
        System.out.print("STEP 5... Logging out from account 'sibelgulmez'\n");
        users.get(0).Logout();  
    
        System.out.print("STEP 6... Logging into another account (username: gokhankaya)\n");
        users.get(2).Login(users);
    
        System.out.println("STEP 7... Viewing sibelgulmez's profile...");
        users.get(2).view(users.get(0));
    
        System.out.println("STEP 8... Viewing sibelgulmez'posts...");
        users.get(2).viewPost(users.get(0), 1);
        users.get(2).viewPost(users.get(0), 0); 
    
        System.out.println("STEP 9... Liking a post of sibelgulmez...");
        users.get(2).addLike(users.get(0), 0);
    
        System.out.println("STEP 10... Adding a comment on a post of sibelgulmez...");
        users.get(2).addComment(users.get(0), 0, "me too");
    
        System.out.println("STEP 11... Following sibelgulmez and gizemsungu...");
        users.get(2).follow(users.get(0));
        users.get(2).follow(users.get(1));
    
        System.out.println("STEP 12... Sending a message to gizemsungu...");
        users.get(2).sendMessage(users.get(1), "This hw is not easy");
    
        System.out.println("STEP 13... Logging out from account 'gokhankaya'..");
        users.get(2).Logout();
    
        System.out.println("STEP 14... Logging into another account (username: gizemsungu)");
        users.get(1).Login(users);
    
        System.out.println("STEP 15... Checking outbox...");
        users.get(1).checkNumOutbox();
    
        System.out.println("STEP 16... Checking inbox...");
        users.get(1).checkNumInbox();
    
        System.out.println("STEP 17");
        users.get(1).viewInbox(users);
    
        System.out.println("STEP 18... Viewing sibelgulmez's profile...");
        users.get(1).view(users.get(0));
    
        System.out.println("STEP 19... Viewing sibelgulmez's posts...");
        users.get(1).viewPost(users.get(0), 0);
        users.get(1).viewPost(users.get(0), 1);
    
        System.out.println("STEP 20... Viewing sibelgulmez's posts' interactions...");
        users.get(1).viewInteraction(users.get(0),users);
    
        System.out.println("STEP 21... Liking sibelgulmez's posts...");
        users.get(1).addLike(users.get(0), 1);
        users.get(1).viewPost(users.get(0), 0);
        users.get(1).addLike(users.get(0), 0);
    
        System.out.println("STEP 22... Viewing sibelgulmez's posts' interactions...");
        users.get(1).viewInteraction(users.get(0),users);
        users.get(1).Logout();

        System.out.println("STEP 23... gizemsungu logs in.");
        users.get(1).Login(users);

        System.out.println("STEP 24... blocks sibelgulmez.");
        users.get(1).block(users.get(0));

        System.out.println("STEP 25... logs out..");
        users.get(1).Logout();

        System.out.println("STEP 26... sibelgulmez logs in.");
        users.get(0).Login(users);

        System.out.println("STEP 27... tries to view the profile of gizemsungu.");
        users.get(0).view(users.get(1));

        System.out.println("STEP 28... tries to send a message to gizemsungu.");
        users.get(0).sendMessage(users.get(1),"helo" );
    

    }
}
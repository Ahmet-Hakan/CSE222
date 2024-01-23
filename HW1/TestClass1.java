package homework1;
class TestClass1
{
    public static void main(String[] args) 
    {
        Account users[] = {
            new Account(0, "sibelgulmez", "10.03.1995", "Istanbul"),
            new Account(1, "gizemsungu", "10.03.1995", "Istanbul"),
            new Account(2, "gokhankaya", "10.03.1995", "Istanbul"),
            };
        
            System.out.print("STEP 1... Creating accounts...\n");
            System.out.print( "An account with username gizemsungu has been created.\n");
            System.out.print("An account with username sibelgulmez has been created.\n");
            System.out.print( "An account with username gokhankaya has been created.\n");
        
            System.out.print("STEP 2... Logging into an account (username: sibelgulmez)\n");
            users[0].Login(users);
        
            System.out.print("STEP 3... Sharing two post\n");
            users[0].addPost(0, "I like Java.");
            users[0].addPost(1, "Java the coffee...");
        
            System.out.print("STEP 4... Following gizemsungu and gokhankaya...\n");
            users[0].follow(users[2]);
            users[0].follow(users[1]);
        
            System.out.print("STEP 5... Logging out from account 'sibelgulmez'\n");
            users[0].Logout();  
        
            System.out.print("STEP 6... Logging into another account (username: gokhankaya)\n");
            users[2].Login(users);
        
            System.out.println("STEP 7... Viewing sibelgulmez's profile...");
            users[2].view(users[0]);
        
            System.out.println("STEP 8... Viewing sibelgulmez'posts...");
            users[2].viewPost(users[0], 1);
            users[2].viewPost(users[0], 0); 
        
            System.out.println("STEP 9... Liking a post of sibelgulmez...");
            users[2].addLike(users[0], 0);
        
            System.out.println("STEP 10... Adding a comment on a post of sibelgulmez...");
            users[2].addComment(users[0], 0, "me too");
        
            System.out.println("STEP 11... Following sibelgulmez and gizemsungu...");
            users[2].follow(users[0]);
            users[2].follow(users[1]);
        
            System.out.println("STEP 12... Sending a message to gizemsungu...");
            users[2].sendMessage(users[1], "This hw is not easy");
        
            System.out.println("STEP 13... Logging out from account 'gokhankaya'..");
            users[2].Logout();
        
            System.out.println("STEP 14... Logging into another account (username: gizemsungu)");
            users[1].Login(users);
        
            System.out.println("STEP 15... Checking outbox...");
            users[1].checkNumOutbox();
        
            System.out.println("STEP 16... Checking inbox...");
            users[1].checkNumInbox();
        
            System.out.println("STEP 17");
            users[1].viewInbox(users);
        
            System.out.println("STEP 18... Viewing sibelgulmez's profile...");
            users[1].view(users[0]);
        
            System.out.println("STEP 19... Viewing sibelgulmez's posts...");
            users[1].viewPost(users[0], 0);
            users[1].viewPost(users[0], 1);
        
            System.out.println("STEP 20... Viewing sibelgulmez's posts' interactions...");
            users[1].viewInteraction(users[0],users);
        
            System.out.println("STEP 21... Liking sibelgulmez's posts...");
            users[1].addLike(users[0], 1);
            users[1].viewPost(users[0], 0);
            users[1].addLike(users[0], 0);
        
            System.out.println("STEP 22... Viewing sibelgulmez's posts' interactions...");
            users[1].viewInteraction(users[0],users);
    }
}
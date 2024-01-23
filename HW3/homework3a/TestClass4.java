package homework3a;
import java.util.ArrayList;
import java.text.*;

class TestClass4
{
    public static void main(String[] args) 
    {
        long start = System.currentTimeMillis();
        ArrayList <Account> users = new  ArrayList <Account>();
        users.add( new Account(0, "sibelgulmez", "10.03.1995", "Istanbul"));
        users.add( new Account(1, "gizemsungu", "10.03.1995", "Istanbul"));
        users.add( new Account(2, "gokhankaya", "10.03.1995", "Istanbul"));
        users.add( new Account(3, "fatihturan", "10.03.1995", "Ankara"));
        users.add( new Account(4, "mehmetbal", "10.03.1995", "Istanbul"));
        users.add( new Account(5, "ayhanakman", "10.03.1995", "Istanbul"));
        users.add( new Account(6, "serdartuncer", "10.03.1995", "Ankara"));
        users.add( new Account(7, "harunyilmaz", "10.03.1995", "Istanbul"));
        users.add( new Account(8, "temelazak", "10.03.1995", "Ankara"));
        users.add( new Account(9, "karsuguney", "10.03.1995", "Ankara"));
        
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

        System.out.println(" STEP23... mehmetbal  Logins");
        users.get(4).Login(users);
        System.out.println("STEP24... mehmetbal  follows gokhankaya gizemsungu ayhanakman fatihturan serdartuncer");
        users.get(4).follow(users.get(2));
        users.get(4).follow(users.get(1));
        users.get(4).follow(users.get(5));
        users.get(4).follow(users.get(3));
        users.get(4).follow(users.get(6));
        System.out.println(" STEP25... viewing mehmetbal account ");
        users.get(4).view(users.get(4));

        System.out.println("STEP26... mehmetbal unfollows gokhankaya gizemsungu");
        users.get(4).unfollow( users.get(1));
        users.get(4).unfollow(users.get(2));

        
        System.out.println(" STEP27... viewing mehmetbal account ");
        users.get(4).view(users.get(4));

        System.out.println(" STEP28... mehmetbal sharing posts ");
        users.get(4).addPost(0,"Java is fun");
        users.get(4).addPost(1,"SUnny Today");

        System.out.println(" STEP29... mehmetbal Logs Out ");
        users.get(4).Logout();

        System.out.println(" STEP30... harunyilmaz Logs in ");
        users.get(7).Login(users);

        System.out.println(" STEP30... viewing mehmetbal account ");
        users.get(7).view(users.get(4));

        System.out.println(" STEP31... harunyilmaz likings mehmetbal posts ");
        users.get(7).addLike(users.get(4), 0);
        users.get(7).addLike(users.get(4), 1);

        System.out.println(" STEP32... harunyilmaz adding commment mehmetbal posts ");
        users.get(7).addComment(users.get(4), 0,"You are right");
        users.get(7).addComment(users.get(4), 1,"Let go outside");

        System.out.println(" STEP33... harunyilmaz views mehmetbal posts interactions");
        users.get(7).viewInteraction(users.get(4),users);

        System.out.println(" STEP34... harunyilmaz unlikings mehmetbal posts ");
        users.get(7).unlike(users.get(4), 0);
        users.get(7).unlike(users.get(4), 1);
        
        System.out.println(" STEP35... harunyilmaz deleting commments mehmetbal posts ");
        users.get(7).uncomment(users.get(4), 0);
        users.get(7).uncomment(users.get(4), 1);

        System.out.println(" STEP36... harunyilmaz views mehmetbal posts interactions");
        users.get(7).viewInteraction(users.get(4),users);

        System.out.println("STEP37... harunyilmaz logs out");
        users.get(7).Logout();

        System.out.println("STEP38... ayhanakman log in");
        users.get(5).Login(users);
        System.out.println("STEP39.. ayhanakman views the account  mehmetbal");
        users.get(5).view(users.get(4));
        
        System.out.println("STEP40.. ayhanakman likes mehmetbal posts");
        users.get(5).addLike(users.get(4), 0);
        users.get(5).addLike(users.get(4), 1);
        
        System.out.println("STEP41.. ayhanakman add comments mahmetbal posts");
        users.get(5).addComment(users.get(4), 0, "I think so");
        users.get(5).addComment(users.get(4), 1, "happy day");

        System.out.println("STEP42... ayhanakman view interaction mehmetbal");
        users.get(5).viewInteraction(users.get(4), users);

        System.out.println("STEP43... ayhanakman unlike and uncomment mehmetbal postID:0");
        users.get(5).unlike(users.get(4), 0);
        users.get(5).uncomment(users.get(4), 0);

        System.out.println("STEP44... ayhanakman view interaction mehmetbal");
        users.get(5).viewInteraction(users.get(4), users);

        System.out.println("STEP45... ayhanakman looks history");
        users.get(5).showHistory();

        System.out.println("STEP46... ayhanakman logs out");
        users.get(5).Logout();

        System.out.println("STEP47... serdartuncer log in");
        users.get(6).Login(users);

        System.out.println("STEP48... serdartuncer blocks temelazak and karsuguney");
        users.get(6).block(users.get(8));
        users.get(6).block(users.get(9));

        System.out.println("STEP49... serdartuncer trys to view, follow and send message karsuguney");
        users.get(6).view(users.get(9));
        users.get(6).follow(users.get(9));
        users.get(6).sendMessage(users.get(9), "never give up");

        System.out.println("STEP50... serdartuncer logs out");
        users.get(6).Logout();

        System.out.println("STEP51... karsuguney log in");
        users.get(9).Login(users);

        System.out.println("STEP52... karsuguney trys to view ,follow and send a message to serdartuncer");
        users.get(9).view(users.get(6));
        users.get(9).follow(users.get(6));
        users.get(9).sendMessage(users.get(6), "trying best");

        System.out.println("STEP53... karsuguney logs out");
        users.get(9).Logout();

        System.out.println("STEP54... serdartuncer log in");
        users.get(6).Login(users);

        System.out.println("STEP55... serdartuncer unblocks temelazak and karsuguney");
        users.get(6).unblock(users.get(8));
        users.get(6).unblock(users.get(9));

        System.out.println("STEP56... serdartuncer view, follow and send message karsuguney");
        users.get(6).follow(users.get(9));
        users.get(6).view(users.get(9));
        users.get(6).sendMessage(users.get(9), "never give up");
        System.out.println("STEP57... serdartuncer views outbox");
        users.get(6).viewOutbox(users);
        users.get(6).Logout();

        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}
public class TestClass 
{
     public static void main(String[] args) throws Exception
     {
        try {
            System.out.println("Original String:\tBuzzing bees buzz.");
            myMap mp = new myMap("Buzzing bees buzz");
            mp.display();
            
            System.out.println("\nSorted  version:");
            MergeSort sort = new MergeSort(mp);
            sort.display();
            
            System.out.println("Original String:\t'Hush, hush!' whispered the rushing wind.");
            myMap mp2 = new myMap("'Hush, hush!' whispered the rushing wind.");
            mp2.display();
            
            System.out.println("\nSorted  version:");
            MergeSort sort2 = new MergeSort(mp2);
            sort2.display();

            myMap mp3 = new myMap("23423");
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
       
     }  
     
}

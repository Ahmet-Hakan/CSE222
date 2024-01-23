/**
 * TestClass
 */
public class TestClass 
{
    public static void main(String[] args)  throws Exception
    {
        myMap mp = new myMap("Hush, hush!' whispered the rushing wind.");
        mp.display();

        SelectionSort selectionSort2 = new SelectionSort(mp);
        selectionSort2.display();

        BubbleSort bubbleSort = new BubbleSort(mp);
        bubbleSort.display();

        MergeSort mergeSort = new MergeSort(mp);
        mergeSort.display();

        InsertionSort insertionSort = new InsertionSort(mp);
        insertionSort.display();

        QuickSort quickSort = new QuickSort(mp);
        quickSort.display();

        System.out.println("The all sorting alghorithms work succesfully.");
        System.out.println("Now see the time has been required ");


        StringBuilder myBuilder = new StringBuilder();
        for(int i=1; i< 50; i++)
        {
            for(int j=0; j<i ;j++)
            myBuilder.append(Character.toChars(i + 96));
            myBuilder.append(" ");
        }
        String bestString = "a bb ccc dddd eeeee ffffff ggggggg hhhhhhhh "+ 
        "iiiiiiiii jjjjjjjjjj kkkkkkkkkkk llllllllllll mmmmmmmmmmmmm nnnnnnnnnnnnnn ";
        myMap bestCaseMap = new myMap(bestString);

        System.out.println("Best Case Scenario ");
        timeCalculate(bestCaseMap);

        myBuilder.delete(0, myBuilder.length()-1);
        for(int i=1; i< 50; i++)
        {
            for(int j=i; j<6 ;j++)
            myBuilder.append(Character.toChars(i + 96));
            myBuilder.append(" ");
        }
        String worstString = "aaaaa bbbb ccc dd e";
        myMap worstCaseMap = new myMap(worstString);

        System.out.println("Worst Case Scenario ");
        timeCalculate(worstCaseMap);

        String averageString = "bbbb aaaaa dd ccc ffffff e";
        myMap averageCasMap = new myMap(averageString);
        
        System.out.println("Average Case Scenario ");
        timeCalculate(worstCaseMap);

    }

    public static void timeCalculate(myMap caseMap)
    {
        long startTime = System.nanoTime();
        BubbleSort bubbleSort = new BubbleSort(caseMap);
        long endTime = System.nanoTime();                                    
        System.out.printf("BubbleSort: %d\n", (endTime  - startTime)/100 );

        startTime = System.nanoTime();
        InsertionSort insertionSort = new InsertionSort(caseMap);
        endTime = System.nanoTime();
        System.out.printf("InsertionSort: %d\n", (endTime  - startTime)/100 );


        startTime = System.nanoTime();
        MergeSort mergeSort = new MergeSort(caseMap);        
        endTime = System.nanoTime();  
        System.out.printf("MergeSort: %d\n", (endTime  - startTime)/100 );


        startTime = System.nanoTime();      
        QuickSort quickSort = new QuickSort(caseMap);
        endTime = System.nanoTime();  
        System.out.printf("QuickSort: %d\n", (endTime  - startTime)/100 );

        startTime = System.nanoTime();
        SelectionSort selectionSort = new SelectionSort(caseMap);
        endTime = System.nanoTime();                                                       
        System.out.printf("SelectionSort: %d\n\n", (endTime  - startTime)/100 );

    }
    
}
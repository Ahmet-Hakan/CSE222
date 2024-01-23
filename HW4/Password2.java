public class Password2
{
    private int password2;
    private boolean validState = false;

    public Password2()
    {
        password2 = 75;
        validState = true;
    }

    public Password2(int password , int [] denominations)
    {
        
        if(password >10 && password <10000)
        {
            if(ExactDivision(password, denominations))
            {
                password2 = password;
                validState = true;
            }
            else
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            
        }
        else
        System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
    }

    private void sort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] > arr[max_idx])
                    max_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public  boolean isExactDivision(int password2, int [] denominations)
    {
        if(password2 == 0) 
        {
            return true;
        }

        if( (password2 / denominations[0] ) >= 1 )
        return isExactDivision(password2 % denominations[0] , denominations);

        else if( (password2 / denominations[1]) >= 1 )
        return isExactDivision(password2 % denominations[1] , denominations);

        else if( (password2 / denominations[2]) >= 1 )
        return isExactDivision(password2 % denominations[2] , denominations);

        else 
        return false;
    }

    public  boolean ExactDivision(int password2, int [] denominations)
    {
        sort(denominations);
        return isExactDivision(password2, denominations);
    }

    public boolean getvalidState()
    {
        return validState;
    }




}
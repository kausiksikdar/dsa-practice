// Find the maximum element in an array
public class max_finder
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println("Max: " + max);
    }
}
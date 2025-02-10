
import java.util.*;

public class basic_binary_search {
    static int binarySearch(int[] arr, int target)
    {
        Arrays.sort(arr);
        int st = 0, end = arr.length-1;
        while(st <= end)
        {
            int mid = st + (end-st)/2;
            if(arr[mid] == target)
            return mid+1;
            else if(arr[mid] > target)
            end = mid - 1;
            else
            st = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,7,5,4,10,11,36,23};
        System.out.println("Element at position: " + binarySearch(arr,15));
    }
}
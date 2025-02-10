public class find_the_1st_and_last_position_of_an_element {
    static int[] findEndPositions(int[] arr, int target)
    {
        int[] ans = new int[2];
        int st = 0, end = arr.length-1;
        //Check for 1st Position
        while(st <= end)
        {
            int mid = st + (end-st)/2;
            if(arr[mid] == target)
            {
                ans[0] = mid+1;
                end = mid - 1;
                
                if(arr[mid-1] != target)
                break;
            }
            else if(arr[mid] > target)
            end = mid - 1;
            else
            st = mid + 1;
        }
        //Check for Last Position
        st = 0;
        end = arr.length-1;
        while(st <= end)
        {
            int mid = st + (end-st)/2;
            if(arr[mid] == target)
            {
                ans[1] = mid+1;
                st = mid + 1;
                
                if(arr[mid+1] != target)
                break;
            }
            else if(arr[mid] > target)
            end = mid - 1;
            else
            st = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,9,10};
        int[] ans = findEndPositions(arr,8);
        for(int i=0;i<2;i++)
        System.out.print(ans[i] + " ");
    }
}

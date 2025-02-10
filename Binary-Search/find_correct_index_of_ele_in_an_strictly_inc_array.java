public class find_correct_index_of_ele_in_an_strictly_inc_array {
    static int findCorrectPosition(int[] arr, int target)
    {
        int st = 0, end = arr.length-1, ans = arr.length;
        while(st<=end)
        {
            int mid = st + (end-st)/2;
            if(arr[mid] == target)
            {
                ans = mid;
                break;
            }
            else if(arr[mid] > target)
            {
                ans = mid;
                end = mid - 1;
            }
            else
            st = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,10,14,20};
        System.out.println(findCorrectPosition(arr,5));
    }
}

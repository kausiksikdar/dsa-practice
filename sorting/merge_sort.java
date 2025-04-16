public class merge_sort
{
    //this is the merge function
    //it merges the two halves of the array
    //TC = O(nlogn)
    //SC = O(n)
    static void merge(int[] arr, int st, int end, int mid)
    {
        //temp array to store the sorted merged array
        int[] temp = new int[end-st+1];

        int left = st, right = mid+1; //pointers to traverse the left and right part
        int tempIndex = 0;//to iterate over temp array

        //merge the two halves, follows stability of an algorithm
        while (left <= mid && right <= end) { 
            if(arr[left] <= arr[right])
            temp[tempIndex++] = arr[left++];
            else
            temp[tempIndex++] = arr[right++];
        }
        //if left part is not over yet
        while (left <= mid) { 
            temp[tempIndex++] = arr[left++];
        }
        //if right part is not over yet
        while (right <= end) { 
            temp[tempIndex++] = arr[right++];
        }

        //fill back to original array
        for(int i = st; i <= end; i++) {
            arr[i] = temp[i-st];
        }
    }
    static void shift(int[] arr, int left, int right)
    {
        int temp = arr[right];
        for(int j=right;j>left;j--)
        {
            arr[j] = arr[j-1];
        }
        arr[left] = temp;
    }
    //TC = O(nlogn)
    //SC = O(logn)
    static void mergeConstantSpace(int[] arr, int st, int end, int mid)
    {
        int left = st, right = mid+1; //pointers to traverse the left and right part

        //merge the two halves, follows stability of an algorithm
        while (left <= mid && right <= end) { 
            if(arr[left] > arr[right])
            {
                shift(arr,left,right);
                left++;
                right++;
                mid++;
            }
            else
            left++;
        }
    }
    static void mergeSort(int[] arr, int st, int end)
    {
        //Base case if arrya have single element or over
        if(st >= end)
        return;

        int mid = st + (end - st) / 2; //find the middle index of the array
        mergeSort(arr,st,mid); //call the fn for the left half
        mergeSort(arr,mid+1,end);//call the fn for the right half
        mergeConstantSpace(arr, st, end, mid);//finally merge the two sorted array 
    }
    static void display(int[] arr)
    {
        for(int j=0;j<arr.length;j++)
        System.out.print(arr[j] + " ");

        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {9,0,2,1,4,3,5,6,7,8,4,3};
        mergeSort(arr, 0, arr.length-1);
        display(arr);
    }
}
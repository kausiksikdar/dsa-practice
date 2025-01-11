import java.util.*;

public class Subsetsums1 {
    static void find(int[] arr, int n, ArrayList<Integer> ans, int ind, int[] s)
    {
        //All elements are precessed then add to answer
        if(ind == n)
        {
            ans.add(s[0]);
            return;
        }
        
        //Include the current element
        s[0]+=arr[ind];
        find(arr,n,ans,ind+1,s);
        
        //Exclude the current element
        s[0]-=arr[ind];
        find(arr,n,ans,ind+1,s);
    }
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        find(arr,arr.length,ans,0,new int[]{0});
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,3};
        ArrayList<Integer> ans = subsetSums(arr);
        for(int i: ans)
        {
            System.out.print(i+" ");
        }
    }
}
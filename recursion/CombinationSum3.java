import java.util.*;
public class CombinationSum3 {
    static void findCombinations(int[] arr, int ind, int k, int n, List<Integer> temp, List<List<Integer>> ans, int[] s)
    {
        if(ind == 9)
        {
            if(temp.size() == k && s[0] == n) 
            {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(s[0] > n)
        return;

        s[0]+=arr[ind];
        temp.add(arr[ind]);
        findCombinations(arr,ind+1,k,n,temp,ans,s);
        s[0]-=arr[ind];
        temp.remove(temp.size()-1);
        findCombinations(arr,ind+1,k,n,temp,ans,s);
    }
    public static List<List<Integer>> combinationSum3(int k, int n, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[9];

        for(int j=0;j<9;j++)
        arr[j] = j+1;

        findCombinations(arr, i, k, n, new ArrayList<>(), ans, new int[]{0});
        return ans;
    }
    public static void main(String[] args) {
        int k = 9, n = 45;
        List<List<Integer>> ans = combinationSum3(k,n, 0);
        for(List<Integer> l : ans)
        {
            System.out.println(l);
        }
    }
}
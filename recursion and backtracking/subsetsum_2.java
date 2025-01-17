import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class subsetsum_2 {
    // Brute force
    //Time complexity: O(4^n*n)
    static void Brute(int[] arr, int n, int ind, ArrayList<Integer> temp, List<List<Integer>> ans)
    {
        if(ind == n)
        {
            Collections.sort(temp);
            if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));

            return;
        }

        ArrayList<Integer> temp_1 = new ArrayList<>(temp);
        temp_1.add(arr[ind]);
        Brute(arr,n,ind+1,temp_1,ans);

        Brute(arr,n,ind+1,temp,ans);
    }
    // Backtracking
    //Time complexity: O(2^n*n)
    static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);

            backtrack(nums, result, temp, i + 1);

            temp.remove(temp.size() - 1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        // Brute(arr,arr.length,0,new ArrayList<>(),ans);
        backtrack(arr, ans, new ArrayList<>(), 0);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subsetsWithDup(arr);
        for(List<Integer> i : ans)
        {
            System.out.println(i);
        }
    }
}

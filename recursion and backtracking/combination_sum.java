import java.util.*;
public class combination_sum {
    //This is bext when repeatation is allowed
    //Time complexity = O(2^n)
    public void helper(List<List<Integer>> ans, int sum, List<Integer> result, int arr[], int target, int start)
    {
        if(sum>target)
        {
            return;
        }
        if(sum==target)
        {
            ans.add(new ArrayList<>(result));
            return;
        }

        for(int i =start; i<arr.length;)
        {
            result.add(arr[i]);
            helper(ans, sum+arr[i], result, arr, target, i);
            i++;
            result.remove(result.size()-1);
        }
    }
    //But if repeatation is not allowed then we can use this
    //Time complexity = O(2^n)
    static void combinations(int[] arr, int n, int target, int index, List<Integer> temp, List<List<Integer>> ans, int sum)
    {
        if(index == n && sum == target)
        {
            ans.add(temp);
            return;
        }
        if(index == n || sum > target)
        return;

        List<Integer> new_temp = new ArrayList<>(temp);
        new_temp.add(arr[index]);
        combinations(arr,n,target,index,new_temp,ans,sum+arr[index]);
        combinations(arr,n,target,index+1,temp,ans,sum);
    }
    public static void main(String[] args) {
        combination_sum obj = new combination_sum();
        int arr[] = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        obj.helper(ans, 0, new ArrayList<>(), arr, target, 0);
        System.out.println(ans);
    }
}

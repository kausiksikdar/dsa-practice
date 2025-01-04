//Find two numbers in an array that add up to a target sum
import java.util.*;
public class two_sum {
    static int[] brute(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        int st = 0, end = n - 1;
        Arrays.sort(nums);
        while(st < end) {
            if(nums[st] + nums[end] == target) {
                result[0] = nums[st];
                result[1] = nums[end];
                break;
            }
            else if(nums[st] + nums[end] < target) {
                st++;
            }
            else {
                end--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("The two numbers are: " + result[0] + " and " + result[1]);
    }
}

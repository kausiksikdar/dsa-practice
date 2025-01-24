
import java.util.ArrayList;
import java.util.List;

public class Min_Coins_needed {
    //TC = O(coins.length)
    static List<Integer> findCoins(int N)
    {
        int[] coins = {2000,500,200,100,50,20,10,5,2,1};
        List<Integer> ans = new ArrayList<>();
        int j=0, notes;

        while(j<coins.length)
        {
            notes = N/coins[j];
            while (notes-->0)
            { 
                ans.add(coins[j]);    
            }
            N%=coins[j];
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findCoins(1143));
    }
}

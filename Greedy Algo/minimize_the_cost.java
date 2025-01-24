
import java.util.*;

public class minimize_the_cost {
    static int findCost(int[] cost, int free)
    {
     int n = cost.length;
     int totalCost = 0;
     Arrays.sort(cost);
     int j=0, k=n-1;
     while (j<=k)
     { 
         totalCost+=cost[j];
         j++;
         k-=free;
     }
     return totalCost;
    }
    public static void main(String[] args) {
     int[] cost = {15,13,6,11,4};
     int k = 2;
     System.out.println(findCost(cost,k));
    }
}

import java.util.*;

public class minimize_and_maximize_the_cost {
    static int[] findCost(int[] cost, int free)
    {
     int n = cost.length;
     int[] totalCost = new int[2];
     Arrays.sort(cost);
     int j=0, k=n-1;
     while (j<=k)
     { 
         totalCost[0]+=cost[j];
         j++;
         k-=free;
     }
     j=n-1;
     k=0;
     while (j>=k)
     {
        totalCost[1]+=cost[j];
        j--;
        k+=free;
     }
     return totalCost;
    }
    public static void main(String[] args) {
     int[] cost = {15,13,6,11,4};
     int k = 2;
     int[] ans = findCost(cost,k);
     for (int j:ans) {
         System.out.print(j + " ");
     }
    }
}

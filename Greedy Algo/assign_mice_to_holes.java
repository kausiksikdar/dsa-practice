import java.util.*;
public class assign_mice_to_holes
{
    static int minTime(int[] mice, int[] holes)
    {
        int minTime = 0;
        Arrays.sort(mice);
        Arrays.sort(holes);

        for(int j=0;j<mice.length;j++)
        {
            minTime = Math.max(minTime, Math.abs(mice[j]-holes[j]));
        }
        return minTime;
    } 
    public static void main(String[] args) {
        int[] mice = {-4,4,0};
        int[] holes = {1,10,5};
        System.out.println(minTime(mice,holes));
    }
}
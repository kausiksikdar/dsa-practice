
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Soln
{
    public int maximizeProfit(int[][] jobDes)
    {
        ArrayList<ArrayList<Integer>> jobData = new ArrayList<>(); //List to store jobData 
        for(int j=0;j<jobDes.length;j++) //To convert jobDes array to joData List to perform different operations easily
        {
            int jobNo = jobDes[j][0];
            int deadLine = jobDes[j][1];
            int profit = jobDes[j][2];
            jobData.add(new ArrayList<>(Arrays.asList(profit, deadLine, jobNo)));
        }
        Collections.sort(jobData,(a,b) -> a.get(0) - b.get(0)); //To sort jobDta List in the basis of profit
        int maxDead =-1; //Variable to store the max deadLine task

        for(int j=0;j<jobDes.length;j++) //To find the max deadLine task to complete
        maxDead = Math.max(maxDead, jobDes[j][1]); 

        int[] deadLineArray = new int[maxDead+1]; //an array that signifies the place available for a specific job

        int maxProfit =0; //variable to store the total profit

        for(int j=0;j<jobData.size();j++) //To traverse the jobData List
        {
            for(int k=jobData.get(j).get(1);k>0;k--) //To traverse the deadLine Array
            {
                if(deadLineArray[k] != 1) //whether we find a place assign the task to that place
                {
                    deadLineArray[k] = 1; //mark the place as filled
                    maxProfit+=jobData.get(j).get(0); //add the profif of that job to the total profit
                    break; //if task is assigned then no more check
                }
            }
        }
        return maxProfit; //The total profit is the answer
    }
}
public class job_sequence_problem
{
    public static void main(String[] args) {
        int[][] jobDes = {
            {1,4,20},
            {4,1,30},
            {3,4,25},
            {2,1,25},
            {5,3,30},
            {6,3,25}
        };
        Soln ob = new Soln();
        System.out.println(ob.maximizeProfit(jobDes));
    }
}
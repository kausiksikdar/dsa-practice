
import java.util.ArrayList;
import java.util.Collections;

class Soln
{
    public ArrayList<ArrayList<Integer>> allMeetings(int[] start, int[] end)
    {
        ArrayList<ArrayList<Integer>> meetingsData = new ArrayList<>();//To store the meeting start and end time in a single place

        for(int j=0;j<start.length;j++) //Create the List by iterating start and end array
        {
            ArrayList<Integer> temp = new ArrayList<>();//Temporary List to store the start and end time of present meeting
            temp.add(start[j]);//Add the start time
            temp.add(end[j]);//Add the end time
            meetingsData.add(temp);//Finally add to meetingsData
        }
        Collections.sort(meetingsData, (a,b) -> a.get(1) - b.get(1));//Sort the meetingsData on the basis of end Time as faster ending a meeting leaves time for another meeting

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(meetingsData.get(0));//First meeting have to hold 

        for(int j=1;j<start.length;j++)//Then check one by one if possible the add to answer
        {
            if(ans.get(ans.size()-1).get(1) < meetingsData.get(j).get(0))//if the end time of prev meeting is less than the start time of present meeting then the present meeting can be hold
            ans.add(meetingsData.get(j));//add to the answer
        }
        
        return ans;//How many meetings can be hold is the final answer
    }
}
public class N_meeting_in_one_room
{
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        Soln ob = new Soln();
        System.out.println(ob.allMeetings(start, end));
    }
}
// Source: LeetCode
import java.util.*;
public class uniqueCharCnt {
    static int uniqueCnt(String s)
    {
        HashSet<Character> uniqueCnt = new HashSet<>();
        for(int j = 0; j < s.length(); j++)
        uniqueCnt.add(s.charAt(j));

        return uniqueCnt.size();
    }
    public static boolean isIsomorphic(String s, String t) {
        //Less unique character str treated as 's' the other one 't'
        if(uniqueCnt(s) > uniqueCnt(t))
        {
            String temp = s;
            s = t;
            t = temp;
        }

        HashMap<Character, Character> m = new HashMap<>();
        int j = 0;
        while(j < s.length())
        {
            if(m.containsKey(s.charAt(j)))
            {
                if(m.get(s.charAt(j)) != t.charAt(j))
                return false;
            }
            else
            m.put(s.charAt(j), t.charAt(j));

            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
}
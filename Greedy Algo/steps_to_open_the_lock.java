class Soln
{
    public int openLock(int lock, int Comb)
    {
        int ans =0;//Variable to store the answer

        while(lock != 0) //take each no of lock and check for rotation till lock exists
        {
            int first = lock%10;//Take the first no of lock from end 
            int second = Comb%10;//Take the first no that needed to open the lock from end

            lock/=10;//remove the last no of lock
            Comb/=10;//remove the last no of comb

            //we have two ways to open a lock either clock-wise or anti-clock-wise, choose which one is min.
            //clock-wise = abs(first-second) 
            //anti-clock-wise = 10 - abs(first-seond), as total no, possible for a specific position of lock is 10, clock-wise and anti-clock-wise is complementary
            ans+=Math.min(Math.abs(first-second), 10-Math.abs(first-second));//take each position's answer and add to final answer
        }
        return ans;//the final answer will be the total steps taken to open the lock
    }
}
public class steps_to_open_the_lock
{
    public static void main(String[] args) {
        int lock = 2222;
        int comb = 9999;
        Soln ob = new Soln();
        System.out.println(ob.openLock(lock, comb));
    }
}
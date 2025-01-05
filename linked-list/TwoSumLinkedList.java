import java.util.*;
public class TwoSumLinkedList {
    public static class ListNode {
        int data;
        ListNode next, prev;
        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static ListNode createDLL(int[] arr, int index, int n, ListNode prev) {
        if (index == n)
            return null;

        ListNode temp = new ListNode(arr[index]);
        temp.next = createDLL(arr, index + 1, n, temp);
        return temp;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, ListNode head) {
        if(head == null || head.next == null) {
            return new ArrayList<>();
        }

        ListNode tail = head;
        
        //Find the last node of the list
        while(tail.next != null)
            tail = tail.next;
        
        ArrayList<ArrayList<Integer>> Pairs = new ArrayList<>();
        
        //As the List is sorted so by comparing the data we can implement two-pointer approach
        //Same elements taking twice is not allowed
        while(head != null && tail != null && head.data < tail.data)
        {
            if(head.data + tail.data == target)
            {
                //Updataion in answer
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(head.data);
                temp.add(tail.data);
                Pairs.add(temp);
                
                head = head.next;
                tail = tail.prev;
            }
            else if(head.data + tail.data > target)
            tail = tail.prev;
            else
            head = head.next;
        }
        return Pairs;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8,9};
        ListNode head = createDLL(arr, 0, arr.length, null);
        int target = 7;
        System.out.println(findPairsWithGivenSum(target, head));
    }
}
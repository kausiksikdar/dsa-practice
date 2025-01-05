public class remove_duplicates_DLL {
    public static class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static Node createDLL(int[] arr, int index, int n, Node prev) {
        if (index == n)
            return null;

        Node temp = new Node(arr[index]);
        temp.next = createDLL(arr, index + 1, n, temp);
        return temp;
    }
     //Overall Time complexity = O(n)
    public static Node removeDuplicates(Node head){
        //If no node or only one node is present that means there is no duplicate
        if(head == null || head.next == null)
        return head;
        
        Node temp = head;
        
        //Check current node with the next node
        while(temp != null && temp.next != null)
        {
            if(temp.data == temp.next.data)
            {
                Node justAfter = temp.next;
                Node AfterJustAfter = justAfter.next;
                
                temp.next = AfterJustAfter;
                
                if(AfterJustAfter != null)
                AfterJustAfter.prev = temp;
            }
            else 
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,4,5};
        Node head = createDLL(arr, 0, arr.length, null);
        head = removeDuplicates(head);
        while (head != null) {
           System.out.print(head.data + " ");
           head = head.next;        
        }
    }
}

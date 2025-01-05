public class reverse_a_SLL {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static ListNode createDLL(int[] arr, int index, int n) {
        if (index == n)
            return null;

        ListNode temp = new ListNode(arr[index]);
        temp.next = createDLL(arr, index + 1, n);
        return temp;
    }
    static ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head, fut;
        while(curr != null)
        {
            fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        return prev;
    }
    public static  ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0)
        return head;

    // Find the length of the list
    ListNode tail = head;
    int len = 0;
    while (tail != null) {
        tail = tail.next;
        len++;
    }

    // Normalize k
    k = k % len;
    if (k == 0) return head;

    // Reverse the entire list
    head = reverse(head);


    // Find the new tail after k positions
    tail = head;
    for (int i = 0; i < k - 1; i++) {
        tail = tail.next;
    }

    // Split the list
    ListNode newHead = tail.next;
    tail.next = null;

    // Reverse both parts
    head = reverse(head);
    newHead = reverse(newHead);

    // Connect the two parts
    tail = head;
    while (tail.next != null) {
        tail = tail.next;
    }
    tail.next = newHead;

    return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8,9};
        ListNode head = createDLL(arr, 0, arr.length);
        int k = 2;
        head = rotateRight(head, k);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

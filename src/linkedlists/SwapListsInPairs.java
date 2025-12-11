package linkedlists;

/*
Given a linked list A, swap every two adjacent nodes and return its head.
NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
Input 1:
 A = 1 -> 2 -> 3 -> 4
Input 2:
 A = 7 -> 2 -> 1
Output 1:
 2 -> 1 -> 4 -> 3
Output 2:
 2 -> 7 -> 1
*/
public class SwapListsInPairs {
    public ListNode swapPairs(ListNode A) {
        ListNode head = new ListNode(0);
        ListNode p1 = head;
        ListNode node = A;
        while (node != null && node.next != null) {
            ListNode temp = node.next.next;
            p1.next = reverse(node);
            p1 = p1.next.next;
            node = temp;
        }
        if (node != null) {
            p1.next = node;
        }
        return head.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode nxt = node.next;
        node.next = prev;
        prev = node;
        nxt.next = prev;
        return nxt;
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);

        SwapListsInPairs obj = new SwapListsInPairs();
        obj.print(obj.swapPairs(A));
    }
}

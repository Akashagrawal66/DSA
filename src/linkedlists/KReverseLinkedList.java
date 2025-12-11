package linkedlists;

/*
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3
Output 1:
 [2, 1, 4, 3, 6, 5]
Output 2:
 [3, 2, 1, 6, 5, 4]
*/
public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode p1 = A;
        ListNode lastNode = A;
        ListNode head = null;
        ListNode prev = null;
        int temp = B;
        while (temp != 0) {
            ListNode nxt = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = nxt;
            --temp;
        }
        head = prev;
        while (p1 != null) {
            ListNode prev1 = null;
            ListNode lastNode1 = p1;
            int temp1 = B;
            while (temp1 != 0) {
                ListNode nxt = p1.next;
                p1.next = prev1;
                prev1 = p1;
                p1 = nxt;
                --temp1;
            }
            lastNode.next = prev1;
            lastNode = lastNode1;
        }
        return head;
    }
}

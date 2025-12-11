package linkedlists;

import java.util.List;

/*
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
NOTE: If B is greater than the size of the list, remove the first node of the list
Try doing it using constant additional space.
Problem Constraints
1 <= |A| <= 106
Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
Output Format
Return the head of the linked list after deleting the B-th element from the end.

Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1
Output 1:
1->2->3->5
Output 2:
*/
public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) {
            return null;
        }
        ListNode node1 = A;
        ListNode node2 = A;
        while (B != 0 && node1 != null) {
            node1 = node1.next;
            --B;
        }
        if (node1 == null) {
            ListNode node = A.next;
            A.next = null;
            return node;
        }
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode temp = node2.next.next;
        node2.next = temp;
        temp = null;
        return A;
    }
}

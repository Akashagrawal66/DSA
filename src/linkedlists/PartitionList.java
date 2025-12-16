package linkedlists;

import java.util.List;

/*
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
You should preserve the original relative order of the nodes in each of the two partitions.
Input 1:
A = [1, 4, 3, 2, 5, 2]
B = 3
Input 2:
A = [1, 2, 3, 1, 3]
B = 2
Output 1:
[1, 2, 2, 4, 3, 5]
Output 2:
[1, 1, 2, 3, 3]
*/
public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        ListNode p1 = A;
        if (A.val >= B) {
            ListNode prev = null;
            while (p1 != null  && p1.val >= B) {
                prev = p1;
                p1 = p1.next;
            }
            if (p1 == null) {
                return A;
            }
            prev.next = p1.next;
            p1.next = A;
        }
        ListNode head = p1;
        while (p1 != null) {
            ListNode p2 = p1.next;
            ListNode prev = p1;
            while (p2 != null  && p2.val >= B) {
                prev = p2;
                p2 = p2.next;
            }
            if (p2 == null) {
                break;
            } else if (p1.next != p2) {
                ListNode nxt2 = p2.next;
                ListNode nxt1 = p1.next;
                p1.next = p2;
                p2.next = nxt1;
                prev.next = nxt2;
            }
            p1 = p2;
        }
        return head;
    }
}

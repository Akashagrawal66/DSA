package linkedlists;

import java.util.List;

/*
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass.
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4
Input 2:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5
Output 1:
 1 -> 4 -> 3 -> 2 -> 5
Output 2:
 5 -> 4 -> 3 -> 2 -> 1
*/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null || B == C) {
            return A;
        }
        int temp = C-B+1;
        B=B-1;
        ListNode left = B == 0 ? null : A;
        ListNode right = A;
        while (B > 1 && left != null) {
            left = left.next;
            --B;
            right = right.next;
            --C;
        }
        while (C != 0 && right != null) {
            right = right.next;
            C--;
        }
        ListNode prev = null;
        ListNode mid = left == null ? A : left.next;
        ListNode firstNode = prev;
        while (temp != 0) {
            ListNode nxt = mid.next;
            mid.next = prev;
            if (prev == null) {
                firstNode = mid;
            }
            prev = mid;
            mid = nxt;
            temp--;
        }
        if (left != null) {
            left.next = prev;
        } else {
            A = prev;
        }
        firstNode.next = right;
        return A;
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
        ReverseLinkedListII obj = new ReverseLinkedListII();
        obj.print(obj.reverseBetween(A, 2, 2));
    }
}

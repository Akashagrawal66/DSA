package linkedlists;

/*
Given a singly linked list A
 A: A0 → A1 → … → An-1 → An
reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [1, 2, 3, 4]
Output 1:
 [1, 5, 2, 4, 3]
Output 2:
 [1, 4, 2, 3]
*/
public class ReOrderList {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        ListNode prev = null;
        ListNode p1 = slow.next;
        slow.next = null;
        while (p1 != null) {
            ListNode nxt = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = nxt;
        }
        p1 = prev;
        ListNode p2 = A;
        return merge(A, p1);
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = p1;
        boolean flag = true;
        while (p1 != null && p2 != null) {
            if (flag) {
                ListNode nxt = p1.next;
                p1.next = p2;
                p1 = nxt;
            } else {
                ListNode nxt = p2.next;
                p2.next = p1;
                p2 = nxt;
            }
            flag = !flag;
        }
        return head;
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
        ReOrderList obj = new ReOrderList();
        obj.print(obj.reorderList(A));
    }
}

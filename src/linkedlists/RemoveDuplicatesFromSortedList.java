package linkedlists;

/*
Given a sorted linked list, delete all duplicates such that each element appears only once.
Input 1:
 1->1->2
Input 2:
 1->1->2->3->3
Output 1:
 1->2
Output 2:
 1->2->3
*/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode p1 = A;
        while (p1 != null && p1.next != null) {
            if (p1.val != p1.next.val) {
                p1 = p1.next;
            } else {
                ListNode nxt = p1.next;
                p1.next = nxt.next;
                nxt.next = null;
            }
        }
        return A;
    }
}

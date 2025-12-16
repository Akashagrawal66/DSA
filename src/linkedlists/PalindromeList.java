package linkedlists;

/*Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
Input 1:
A = [1, 2, 2, 1]
Input 2:
A = [1, 3, 2]
Output 1:
 1
Output 2:
 0

*/
public class PalindromeList {
    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }
        slow = prev;
        fast = A;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return 0;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return 1;
    }
}

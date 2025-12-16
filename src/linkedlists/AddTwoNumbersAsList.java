package linkedlists;

import java.util.List;

/*
You are given two linked lists, A and B, representing two non-negative numbers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return it as a linked list.
Input 1:
 A = [2, 4, 3]
 B = [5, 6, 4]
Input 2:
 A = [9, 9]
 B = [1]
Output 1:
 [7, 0, 8]
Output 2:
 [0, 0, 1]
*/
public class AddTwoNumbersAsList {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode p1 = A;
        ListNode p2 = B;
        int carry = 0;
        ListNode result = null;
        ListNode p3 = result;
        while (p1 != null && p2 != null) {
            int num1 = p1.val;
            int num2 = p2.val;
            int sum = carry + (num1 + num2);
            carry = sum / 10;
            sum %= 10;
            if (result == null) {
                result = new ListNode(sum);
                p3 = result;
            } else {
                p3.next = new ListNode(sum);
                p3 = p3.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int num1 = p1.val;
            int sum = carry + num1;
            carry = sum / 10;
            sum %= 10;
            p3.next = new ListNode(sum);
            p3 = p3.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int num1 = p2.val;
            int sum = carry + num1;
            carry = sum / 10;
            sum %= 10;
            p3.next = new ListNode(sum);
            p3 = p3.next;
            p2 = p2.next;
        }
        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return result;
    }
    private void print(ListNode head) {
        ListNode p1 = head;
        while (p1 != null) {
            System.out.println(p1.val);
            p1 = p1.next;
        }
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(6);
        A.next = new ListNode(4);
        A.next.next = new ListNode(3);

        ListNode B = new ListNode(4);
//        B.next = new ListNode(5);
//        B.next.next = new ListNode(6);

        AddTwoNumbersAsList obj = new AddTwoNumbersAsList();
        ListNode result = obj.addTwoNumbers(A, B);
        obj.print(result);
    }
}

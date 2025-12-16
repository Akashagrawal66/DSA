package linkedlists;

/*You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
*/
public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        addDuplicates(head);
        addRandomPointersToDuplicates(head);
        return separateDuplicateList(head);
    }

    private RandomListNode separateDuplicateList(RandomListNode head) {
        RandomListNode p1 = head;
        RandomListNode p2 = head.next;
        RandomListNode result = p2;
        while (p2 != null && p2.next != null) {
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    private void addRandomPointersToDuplicates(RandomListNode head) {
        RandomListNode p1 = head;
        while (p1 != null) {
            RandomListNode dup = p1.next;
            if (p1.random != null)
                dup.random = p1.random.next;
            p1 = p1.next.next;
        }
    }

    private void addDuplicates(RandomListNode head) {
        RandomListNode p1 = head;
        while (p1 != null) {
            RandomListNode dup = new RandomListNode(p1.label);
            RandomListNode nxt = p1.next;
            p1.next = dup;
            dup.next = nxt;
            p1 = nxt;
        }
    }
    public void print(RandomListNode head) {
        RandomListNode p1 = head;
        while (p1 != null) {
            System.out.println(p1.label);
            System.out.println("Its Random: "+p1.random.label);
            p1 = p1.next;

        }

    }

    public static void main(String[] args) {
        RandomListNode l = new RandomListNode(1);
        l.next = new RandomListNode(2);
        l.next.next = new RandomListNode(3);
        l.random = l.next.next;
        l.next.random = l;
        l.next.next.random = l;
        CopyList obj = new CopyList();
        RandomListNode copy =obj.copyRandomList(l);
        obj.print(copy);
    }
}

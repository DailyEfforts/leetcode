package _0021;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode first = null;
        ListNode last = null;
        while (l1 != null && l2 != null) {
            ListNode node = null;
            if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (first == null) {
                first = node;
            }
            if (last != null) {
                last.next = node;
            }
            last = node;
        }

        if (l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return first;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(3);
        ListNode n13 = new ListNode(5);
        n11.next = n12;
        n12.next = n13;
        ListNode n21 = new ListNode(2);
        ListNode n22 = new ListNode(6);
        n21.next = n22;
        Solution solution = new Solution();
        ListNode node = solution.mergeTwoLists(n11, n21);
        while (node != null) {
            System.out.print(node + " ");
            node = node.next;
        }
        System.out.println();
    }
}

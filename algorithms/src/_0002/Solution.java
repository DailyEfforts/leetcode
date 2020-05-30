package _0002;

public class Solution {
    final ListNode fakeFirst = new ListNode(-1);
    ListNode currentNode = fakeFirst;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            carry = append(l1, carry);
        }
        if (l2 != null) {
            carry = append(l2, carry);
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
            currentNode = currentNode.next;
        }
        return fakeFirst.next;
    }

    private int append(ListNode src, int carry) {
        while (src != null) {
            int sum = carry + src.val;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            src = src.next;
        }
        return carry;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        l11.next = l12;

        ListNode l21 = new ListNode(1);
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l11, l21);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

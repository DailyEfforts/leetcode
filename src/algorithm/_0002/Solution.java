package algorithm._0002;

public class Solution {
    final ListNode fakeFirst = new ListNode(-1);
    ListNode currentNode = fakeFirst;

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

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int carry = 0;
        while (a != null && b != null) {
            int sum = carry + a.val + b.val;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            carry = append(a, carry);
        }
        if (b != null) {
            carry = append(b, carry);
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
}

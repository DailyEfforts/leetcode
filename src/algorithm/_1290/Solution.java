package algorithm._1290;

import algorithm.common.ListNode;

import java.util.LinkedList;

public class Solution {
    public int getDecimalValue(ListNode head) {
        final LinkedList<ListNode> stack = new LinkedList<>();
        for (ListNode node = head; node != null; node = node.next) {
            stack.add(node);
        }
        int count = 0;
        int weight = 0;
        while (!stack.isEmpty()) {
            int val = stack.removeLast().val;
            count += val * pow(weight++);
        }
        return count;
    }

    private int pow(int times) {
        int sum = 1;
        for (int i = 0; i < times; i++) {
            sum = sum * 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        a.next = b;
        System.out.println(new Solution().getDecimalValue(a));
    }
}

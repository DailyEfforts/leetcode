package add_two_numbers;

import java.util.ArrayList;
import java.util.List;


// TODO: Fix `Time Limit Exceeded` issue.
public class Solution {
    private List<Integer> list = new ArrayList<Integer>();

    private void push(Integer i) {
        list.add(i);
    }

    private boolean isEmpty() {
        return list.size() == 0;
    }

    private ListNode pop() {
        final int size = list.size();
        if (size > 1) {
            int value = list.remove(size - 1) + list.remove(size - 2);
            if (value >= 10) {
                if (size > 2) {
                    list.set(size - 3, list.get(size - 3) + 1);
                } else {
                    push(1);
                }
                value -= 10;
            }
            return new ListNode(value);
        } else if (size == 1) {
            return new ListNode(1);
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            push(l1.val);
            push(l2.val);
        }
        if (isEmpty()) {
            return null;
        }
        ListNode first = pop();
        ListNode lastNode = first;
        while (!isEmpty()) {
            ListNode x = pop();
            lastNode.next = x;
            lastNode = x;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l11, l21);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

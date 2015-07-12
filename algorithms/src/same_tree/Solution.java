package same_tree;

import common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.<br/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    private void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print((char) node.val + " ");
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode pA = new TreeNode('A');
        TreeNode pB = new TreeNode('B');
        TreeNode pC = new TreeNode('C');
        TreeNode pD = new TreeNode('D');
        TreeNode pE = new TreeNode('E');
        pA.left = pB;
        pB.left = pD;
        pB.right = pE;
        pA.right = pC;
        TreeNode qA = new TreeNode('A');
        TreeNode qB = new TreeNode('B');
        TreeNode qC = new TreeNode('C');
        TreeNode qD = new TreeNode('D');
        TreeNode qE = new TreeNode('E');
        qA.left = qB;
        qB.left = qD;
        qB.right = qE;
        qA.right = qC;
        solution.print(pA);
        System.out.println();
        solution.print(qA);
        System.out.println();
        System.out.println(solution.isSameTree(pA, qA));
        System.out.println(solution.isSameTree(pA, qB));
    }
}

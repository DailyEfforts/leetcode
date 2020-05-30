package _0112;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            sum -= root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(8);
        TreeNode node21 = new TreeNode(11);
        TreeNode node22 = new TreeNode(13);
        TreeNode node23 = new TreeNode(4);
        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(2);
        TreeNode node33 = new TreeNode(1);
        root.left = node11;
        node11.left = node21;
        node21.left = node31;
        node21.right = node32;
        root.right = node12;
        node12.left = node22;
        node12.right = node23;
        node23.right = node33;
        print(root);

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root, 22));
        System.out.println(solution.hasPathSum(root, 27));
        System.out.println(solution.hasPathSum(root, 97));
    }

    private static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        print(node.left);
        print(node.right);
    }
}

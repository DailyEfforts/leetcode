package algorithm._0226;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        final TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
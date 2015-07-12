package invert_binary_tree;

import common.TreeNode;

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
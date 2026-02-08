/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int height(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        if (lh == -1) return -1;   // left unbalanced

        int rh = height(root.right);
        if (rh == -1) return -1;  // right unbalanced

        if (Math.abs(lh - rh) > 1) return -1; // current node unbalanced

        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
}


/*  

*/
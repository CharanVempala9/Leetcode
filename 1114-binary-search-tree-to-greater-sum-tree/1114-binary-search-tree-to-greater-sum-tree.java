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
    public int num=0;
    public TreeNode rec(TreeNode root){
        if(root==null){
            return null;
        }
        root.right=rec(root.right);
        num+=root.val;
        root.val=num;
        root.left=rec(root.left);
        return root;
    }
    public TreeNode bstToGst(TreeNode root) {
        return rec(root);
    }
}
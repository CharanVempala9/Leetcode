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
    public boolean helper(TreeNode node, int t){
        if(node==null){
            return  false;
        }
        if(t==node.val && node.left==null && node.right==null){
            return true;
        }
        return (helper(node.left,t-node.val) || helper(node.right,t-node.val));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return  helper(root,targetSum);
    }
}
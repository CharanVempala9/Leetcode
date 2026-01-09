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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int max=Math.max(left,right)+1;
        return max;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDpt=height(root);
        return dfs(root,maxDpt,0);
    }
    public TreeNode dfs(TreeNode root,int max,int l){
        if(root==null){
            return null;
        }
        if(max-1==l){
            return root; 
        }
        TreeNode left=dfs(root.left,max,l+1);
        TreeNode right=dfs(root.right,max,l+1);
        if(left!=null && right!=null) return root;
        return left!=null ? left : right;
    }
}
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
    int sum;
    public void dfs(TreeNode root,int val){
        if(root==null)return;
        val=val*2+root.val;
        if(root.left==null && root.right==null){
            sum+=val;
            return;
        }
        dfs(root.left,val);
        dfs(root.right,val);
    }
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return sum;
    }
}
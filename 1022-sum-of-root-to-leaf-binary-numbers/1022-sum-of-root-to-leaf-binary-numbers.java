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
    public void dfs(TreeNode root,String val){
        if(root==null)return;
        val+=root.val;
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(val,2);
            return;
        }
        dfs(root.left,val);
        dfs(root.right,val);
    }
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,"");
        return sum;
    }
}
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ls=new ArrayList<>();
        rec(root,ls);
        return ls;
    }
    public void rec(TreeNode root,List<Integer>ls){
        if(root==null)
        return;
        rec(root.left,ls);
        ls.add(root.val);
        rec(root.right,ls);
    }
}
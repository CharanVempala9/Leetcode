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
    int ans=0;
    public int helper(TreeNode node, int start){
        if(node==null){
            return 0;
        }
        int left=helper(node.left,start);
        int right=helper(node.right,start);

        if(node.val==start){
            ans=Math.max(ans,Math.max(left,right));
            return -1;
        }
        if(left>=0 && right>=0){
            return Math.max(left,right)+1;
        }
        ans=Math.max(ans,Math.abs(left)+Math.abs(right));

        return Math.min(left,right)-1;
    }
    public int amountOfTime(TreeNode root, int start) {
        helper(root,start);
        return ans;
    }
}
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
    public TreeNode rec(int l,int end,int[] nums){
        if(l>=end){
            return null;
        }
        int idx=l;
        for(int i=l; i<end;  i++){
            if(nums[i]>nums[idx])
            idx=i;
        }
        TreeNode root =new TreeNode(nums[idx]);
        root.left = rec(l,idx,nums);
        root.right= rec(idx+1,end,nums);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int l=0;
        int h=nums.length;
        return rec(l,h,nums);
    }
}
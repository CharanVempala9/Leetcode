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
    public void helper(TreeNode root, int targetSum,List<Integer>ls,List<List<Integer>>res){
        if(root==null){
            return;
        }
        ls.add(root.val);
        if(root.val==targetSum && root.left==null && root.right==null){
            res.add(new ArrayList<>(ls));
        }
        helper(root.left,targetSum-root.val,ls,res);
        helper(root.right,targetSum-root.val,ls,res);
        
        ls.remove(ls.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        helper(root,targetSum,new ArrayList<>(),res);
        return res;
    }
}
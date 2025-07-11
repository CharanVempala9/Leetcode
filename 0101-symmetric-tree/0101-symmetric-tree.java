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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>ls=new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                if(node==null)
                ls.add(-111);
                else {
                    ls.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            int s=ls.size();
            System.out.println(ls.toString());
            int last=s-1;
            for(int i=0; i<s/2; i++){
                if(ls.get(i)!=ls.get(last)){
                    return false;
                }
                last--;
            }
        }
        return true;
    }
}
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
    public int maxLevelSum(TreeNode root) {
        //ArrayList<ArrayList<Integer>>ls=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int max=Integer.MIN_VALUE;
        int lvl=0;
        int idx=1;
        while(!q.isEmpty()){
            int s=q.size();
            int sum=0;
            for(int i=0; i<s; i++){
                TreeNode p=q.poll();
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
                sum+=p.val;
            }
            if(sum>max){
               lvl=idx; 
               max=sum;
            }
            idx++;
        }
        return lvl;
    }
}
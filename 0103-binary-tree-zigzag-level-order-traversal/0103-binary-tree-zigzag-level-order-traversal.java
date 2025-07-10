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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode>dq=new LinkedList<>();
        dq.offerLast(root);
        boolean left=true;
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer>ls=new ArrayList<>();
            for(int i=0; i<size; i++){
                if(left){
                    TreeNode node=dq.pollFirst();
                    ls.add(node.val);
                    if(node.left!=null){
                        dq.offerLast(node.left);
                    }
                    if(node.right!=null){
                        dq.offerLast(node.right);
                    }
                }
                else{
                    TreeNode node=dq.pollLast();
                    ls.add(node.val);
                    if(node.right!=null){
                        dq.offerFirst(node.right);
                    }
                    if(node.left!=null){
                        dq.offerFirst(node.left);
                    }
                }
            }
            left=!left;
            res.add(ls);
        }
        return res;
    }
}
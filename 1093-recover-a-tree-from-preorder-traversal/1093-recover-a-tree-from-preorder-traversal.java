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
    int index=0;
    int n=0;
    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        return rec(traversal,0);
    }
    public TreeNode rec(String traversal,int depth){
        if(index>=n){
            return null;
        }
        int cnt=0;
        int temp=index;
        while(temp<n && !Character.isDigit(traversal.charAt(temp))){
            cnt++;
            temp++;
        }
        if(cnt!=depth) return null;
        index=temp;
        int val=0;
        while(index<n && Character.isDigit(traversal.charAt(index))){
            val=val*10+traversal.charAt(index)-'0';
            index++;
        }
        TreeNode node=new TreeNode(val);
        node.left=rec(traversal,depth+1);
        node.right=rec(traversal,depth+1);
        return node;
    }
}
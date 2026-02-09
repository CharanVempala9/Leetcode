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
    public TreeNode Build(ArrayList<Integer>ls,int l,int h){
        if(l>h)return null;
        int mid = l+(h-l)/2;
        TreeNode root=new TreeNode(ls.get(mid));
        root.left=Build(ls,l,mid-1);
        root.right=Build(ls,mid+1,h);
        return root;
    }
    public void inOrder(TreeNode root,ArrayList<Integer>ls){
        if(root==null){
            return;
        }
        inOrder(root.left,ls);
        ls.add(root.val);
        inOrder(root.right,ls);
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return root;
        ArrayList<Integer>ls=new ArrayList<>();
        inOrder(root,ls);
        return Build(ls,0,ls.size()-1);
    }
}
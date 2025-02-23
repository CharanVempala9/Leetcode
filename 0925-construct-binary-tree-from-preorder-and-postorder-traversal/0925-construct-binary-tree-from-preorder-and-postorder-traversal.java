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
    HashMap<Integer,Integer>hm=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        for(int i=0; i<n; i++){
            hm.put(postorder[i],i);
        }
        return rec(0,n-1,0,n-1,preorder,postorder);
    }
    public TreeNode rec(int i1, int i2, int j1, int j2, int[] preorder, int[] postorder){
        if(i1>i2 ||  j1>j2){
            return null;
        }
        TreeNode root=new TreeNode(preorder[i1]);
        if(i1==i2)
        return root;
        int r=hm.get(preorder[i1+1]);
        int size= r-j1+1;
        root.left=rec(i1+1,i1+size, j1,r,preorder, postorder );
        root.right=rec(i1+size+1,i2,r+1,j2,preorder, postorder );
        return root;
    }
}
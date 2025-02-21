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
class FindElements {
    HashSet<Integer>hs=new HashSet<>();
    public FindElements(TreeNode root) {
        preorder(root,0);
    }
    
    public boolean find(int target) {
        if(hs.contains(target))
        return true;
        else
        return false;
    }
    void preorder(TreeNode root,int val){
        
        if(root==null){
            return;
        }
        hs.add(val);
        preorder(root.left,2*val+1);
        preorder(root.right,2*val+2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
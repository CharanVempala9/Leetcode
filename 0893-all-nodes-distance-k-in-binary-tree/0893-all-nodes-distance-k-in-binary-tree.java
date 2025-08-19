/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>(); 
    public void buildParent(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parentMap.put(root, parent);
        buildParent(root.left, root);
        buildParent(root.right, root);
    }
    public void get(TreeNode root, int k, List<Integer> ls, Set<TreeNode> visited) {
        if (root == null || visited.contains(root)) return;
        visited.add(root);
        
        if (k == 0) {
            ls.add(root.val);
            return;
        }
        
        get(root.left, k - 1, ls, visited);
        get(root.right, k - 1, ls, visited);
        get(parentMap.get(root), k - 1, ls, visited); 
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls = new ArrayList<>();
        buildParent(root, null); 
        Set<TreeNode> visited = new HashSet<>();
        get(target, k, ls, visited); 
        return ls;
    }
}

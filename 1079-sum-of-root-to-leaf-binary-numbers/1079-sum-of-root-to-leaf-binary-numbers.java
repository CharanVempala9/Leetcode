class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = (sum << 1) | node.val;

        if (node.left == null && node.right == null) {
            return sum; 
        }

        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}

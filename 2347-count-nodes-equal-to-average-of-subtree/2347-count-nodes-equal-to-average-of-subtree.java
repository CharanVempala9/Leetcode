class Solution {
    private int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        if (root.val == sum / count) {
            ans++;
        }

        return new int[]{sum, count};
    }
}

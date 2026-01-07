class Solution {
    long totsum;
    long ans = 0;
    public void dfs(TreeNode root){
        if(root == null) return;
        totsum += root.val;
        dfs(root.left);
        dfs(root.right);
    }
    public long Adfs(TreeNode root, long sum){
        if(root == null) return 0;
        long l = Adfs(root.left, sum);
        long r = Adfs(root.right, sum);
        long Asum = root.val + l + r;
        ans = Math.max(ans, (sum - Asum) * Asum);
        return Asum;
    }
    public int maxProduct(TreeNode root) {
        int mod = 1000000007;
        dfs(root);
        Adfs(root, totsum);
        return (int)(ans % mod);
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && node.right != null) {
                    int l = node.left.val;
                    int r = node.right.val;
                    if ((l == x && r == y) || (l == y && r == x)) {
                        return false; 
                    }
                }

                if (node.val == x) xFound = true;
                if (node.val == y) yFound = true;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (xFound && yFound) return true;

            if (xFound || yFound) return false;
        }

        return false;
    }
}

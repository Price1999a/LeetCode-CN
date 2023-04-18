package leetcode.cn;

public class Q1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int res;

    public int maxAncestorDiff(TreeNode root) {
        res = root.val;
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        int val = root.val;
        res = Math.max(res, Math.max(Math.abs(val - min), Math.abs(val - max)));
        dfs(root.left, Math.min(min, val), Math.max(max, val));
        dfs(root.right, Math.min(min, val), Math.max(max, val));
    }
}

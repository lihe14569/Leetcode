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
    int sum = 0, depth = -1;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    public void dfs(TreeNode root, int d) {
        if(root == null) return;
        if(d > depth) {
            depth = d;
            sum = root.val;
        } else if(d == depth) sum += root.val;
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
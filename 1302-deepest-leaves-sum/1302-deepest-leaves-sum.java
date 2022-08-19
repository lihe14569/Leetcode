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
    int res = 0;
    int maxDepth = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public int dfs(TreeNode root, int depth) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) { //leave
            if(depth > maxDepth) {
                maxDepth = depth;
                res = 0;
                res += root.val;
            } else if(depth == maxDepth) {
                res += root.val;
            }
            
        }
        return dfs(root.left, depth + 1) + dfs(root.right, depth + 1);
    }
}
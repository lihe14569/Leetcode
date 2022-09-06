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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null ) return root;
        
        dfs(root);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
    public boolean dfs(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null && root.val == 0)) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(left) root.left = null;
        if(right) root.right = null;
        if(root.val == 0 && left && right) return true;
        else return false;
    }
}
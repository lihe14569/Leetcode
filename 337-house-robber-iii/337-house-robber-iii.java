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
    //top-down recursion + memo
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        //base case
        if(root == null) return 0;
        //check memo
        if(memo.containsKey(root)) return memo.get(root);
        int rob = root.val;
        if(root.left != null) rob += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) rob += rob(root.right.left) + rob(root.right.right);
        int not_rob = rob(root.left) + rob(root.right);
        int res = Math.max(rob, not_rob);
        memo.put(root, res);
        return res;
    }
}
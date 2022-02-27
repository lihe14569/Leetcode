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
    class Pair{
        TreeNode node;
        int d;
        public Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = LCA(root, 0);
        return p.node;
    }
    public Pair LCA(TreeNode root, int d) {
        if(root == null) return new Pair(null, d);
        Pair l = LCA(root.left, d + 1);
        Pair r = LCA(root.right, d + 1);
        if(l.d == r.d) {
            return new Pair(root, l.d);
        } else {
            return l.d < r.d ? r : l;
        }
    }
}
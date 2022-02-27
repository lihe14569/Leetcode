/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //three pass
        TreeNode pNode = find(root, p);
        TreeNode qNode = find(root, q);
        if(pNode == null || qNode == null) return null;
        return LCA(root, p, q);
    }
    public TreeNode find(TreeNode root, TreeNode target) {
        if(root == null || target == null) return null;
        if(root == target) return root;
        TreeNode left = find(root.left, target);
        TreeNode right= find(root.right, target);
        return left == null ? right : left;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        return null;
    }
}
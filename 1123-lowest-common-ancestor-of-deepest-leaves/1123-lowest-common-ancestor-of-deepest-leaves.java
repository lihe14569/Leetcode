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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        //O(n^2)
        if(root == null) return null;
        int l = height(root.left);
        int r = height(root.right);
        if(l == r) return root;
        else if(l > r) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }
    //get the height of current node
    public int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
     
}
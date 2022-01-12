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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //recursive
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode curr = root, prev = null;
        while(curr != null) {
            if(val > curr.val) {
                if(curr.right != null) curr = curr.right;
                else {
                    TreeNode newNode = new TreeNode(val);
                    curr.right = newNode;
                    return root;
                }
            } 
            else {
                if(curr.left != null) curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    return root;
                }
            }
        }
        return root;
    }
}
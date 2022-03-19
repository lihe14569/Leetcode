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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        rightView(root, res, 0);
        return res;
    }
    public void rightView(TreeNode root, List<Integer> res, int depth) {
        //base case
        if(root == null) return;
        
        if(res.size() == depth)
            res.add(root.val);
        
        rightView(root.right, res, depth + 1);
        rightView(root.left, res, depth + 1);
    } 
}
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
    int cnt = 0;
    public int minCameraCover(TreeNode root) {
        if(helper(root) == 0)
            cnt += 1;
        return cnt;
    }
    //2: covered
    //1: placed camera
    //0: not covered
    public int helper(TreeNode root) {
        if(root == null) return 2;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == 0 || right == 0) {
            cnt += 1;
            return 1;
        }
        if(left == 2 && right == 2) {
            return 0;
        } else  return 2; //注意：
    }
}
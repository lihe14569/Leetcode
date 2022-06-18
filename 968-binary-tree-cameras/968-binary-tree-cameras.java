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
        if(dfs(root) == 0)
            cnt += 1;
        return cnt;
    }
    //0: not coverd 
    //1: place a camera
    //2: covered null or covered nodes
    int dfs(TreeNode root) {
        if(root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 2 && right == 2) {
            return 0;
        } else if ( left == 0 || right == 0) {
            cnt += 1;
            return 1;
        } else { //1 and 2
            return 2;
        }
    }
}
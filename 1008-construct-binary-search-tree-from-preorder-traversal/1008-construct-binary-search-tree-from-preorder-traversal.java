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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        return dfs(preorder, Integer.MAX_VALUE);
    }
    TreeNode dfs(int[] nums, int upper) {
        if(i == nums.length || nums[i] > upper) return null;
        TreeNode root = new TreeNode(nums[i++]);
        root.left = dfs(nums, root.val);
        root.right = dfs(nums, upper);
        return root;
    }
}
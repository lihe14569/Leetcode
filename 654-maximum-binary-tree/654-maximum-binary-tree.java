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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    public TreeNode buildTree(int[] nums, int l, int r) {
        if(l > r) return null;
        if(l == r) return new TreeNode(nums[l]);
        int[] rootVal = findMax(nums, l, r);
        TreeNode root = new TreeNode(rootVal[0]);
        
        root.left = buildTree(nums, l, rootVal[1] - 1);
        root.right = buildTree(nums, rootVal[1] + 1, r);
        return root;
    }
    public int[] findMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = l; i <= r; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return new int[]{max, idx};
    }
}
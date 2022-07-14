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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, null, null);
    }
    public TreeNode dfs(int[] preorder, Integer min, Integer max) {
        if(idx == preorder.length) return null;
        if((min != null && preorder[idx] <= min)||(max != null && preorder[idx] >= max)) return null;
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = dfs(preorder, min, root.val);
        root.right = dfs(preorder, root.val, max);
        return root;
    }
}
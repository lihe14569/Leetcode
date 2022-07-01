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
    int[] preorder, inorder;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = inorder.length;
    
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        
        return dfs(0, n - 1, map);
    }
    TreeNode dfs(int istart, int iend, Map<Integer, Integer> map) {
        if(istart > iend) return null;
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        int inorderIdx = map.get(root.val);
        root.left = dfs(istart, inorderIdx - 1, map);
        root.right = dfs(inorderIdx + 1, iend, map);
        return root;
    }
}
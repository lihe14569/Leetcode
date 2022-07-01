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
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int n = inorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        
        return dfs(0, n - 1, 0, n - 1);
    }
    public TreeNode dfs(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(root.val);
        int rightLen = inEnd - idx;
        root.left = dfs(inStart, idx - 1, postStart, postEnd - rightLen - 1);
        root.right = dfs(idx + 1, inEnd, postEnd - rightLen, postEnd- 1);
        return root;
    }
}
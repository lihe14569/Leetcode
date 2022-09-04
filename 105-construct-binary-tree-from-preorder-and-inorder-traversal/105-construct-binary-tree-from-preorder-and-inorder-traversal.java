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
    int[] preorder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        return dfs(0, n - 1, 0, n - 1);
    }
    public TreeNode dfs(int pstart, int pend, int istart, int iend) {
        if(pstart > pend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIndex = map.get(preorder[pstart]);
        int leftCount = rootIndex - istart;
        root.left = dfs(pstart + 1, pstart + leftCount, istart, rootIndex - 1);
        root.right = dfs(pstart + leftCount + 1, pend, rootIndex + 1, iend);
        return root;
    }
}
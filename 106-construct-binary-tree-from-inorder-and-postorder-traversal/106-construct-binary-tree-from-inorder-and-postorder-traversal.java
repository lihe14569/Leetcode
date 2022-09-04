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
        map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++) map.put(inorder[i], i);
        int n = inorder.length;
        return dfs(0, n - 1, 0, n - 1);
    }
    public TreeNode dfs(int istart, int iend, int pstart, int pend) {
        if(istart > iend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int rootIndex = map.get(postorder[pend]);
        int left = rootIndex - istart;
        int right = iend - rootIndex;
        root.left = dfs(istart, rootIndex - 1, pstart, pend - right - 1);
        root.right = dfs(rootIndex + 1, iend, pend - right, pend - 1);
        return root;
    }
}
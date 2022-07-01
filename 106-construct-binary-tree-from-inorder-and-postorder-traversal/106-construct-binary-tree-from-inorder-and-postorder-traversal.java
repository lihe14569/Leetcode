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
    int[] iorder;
    int[] porder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        iorder = inorder;
        porder = postorder;
        int n = iorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        return dfs(0, n -1, 0, n -1);
    }
    public TreeNode dfs(int iS, int iE, int pS, int pE) {
        if(iS > iE) return null;
        TreeNode root = new TreeNode(porder[pE]);
        int idx = map.get(root.val);
        int rightLen = iE - idx;
        root.left = dfs(iS, idx - 1, pS, pE - 1 - rightLen);
        root.right = dfs(idx + 1, iE, pE - rightLen, pE - 1);
        return root;
    }
}
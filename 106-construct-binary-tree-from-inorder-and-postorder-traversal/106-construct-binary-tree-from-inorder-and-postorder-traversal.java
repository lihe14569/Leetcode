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
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return dfs(0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode dfs(int istart, int iend, int pstart, int pend) {
        if(istart > iend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int idx = map.get(root.val);
        int rightLen = iend - idx;
        
        root.left = dfs(istart, idx - 1, pstart, pend - rightLen - 1);
        root.right = dfs(idx + 1, iend, pend - rightLen, pend - 1);
        
        return root;
    }
}
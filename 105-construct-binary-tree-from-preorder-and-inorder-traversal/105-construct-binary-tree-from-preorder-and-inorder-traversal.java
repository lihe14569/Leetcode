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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode constructTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(istart > iend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int idx = map.get(preorder[pstart]);
        int leftLen = idx - istart;
        root.left = constructTree(preorder, pstart + 1, pstart + leftLen, inorder, istart, idx - 1);
        root.right = constructTree(preorder, pstart + leftLen + 1, pend, inorder, idx + 1, iend);
        return root;
    } 
}
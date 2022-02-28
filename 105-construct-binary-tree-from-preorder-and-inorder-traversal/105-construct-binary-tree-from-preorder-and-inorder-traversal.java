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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder to set the root
        //inorder to determine the number of nodes
        int n = preorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < n; i++) inorderMap.put(inorder[i], i);
        return constructTree(preorder, inorder, inorderMap, 0, n - 1, 0, n - 1);
    }
    public TreeNode constructTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int pStart, int pEnd, int iStart, int iEnd) {
        if(pStart > pEnd) return null;
        int rootIdx = inorderMap.get(preorder[pStart]);
        int leftNum = rootIdx - iStart;
        int rightNum = iEnd - rootIdx;
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = constructTree(preorder, inorder, inorderMap, pStart + 1, pStart + leftNum, iStart, rootIdx - 1);
        root.right = constructTree(preorder, inorder, inorderMap, pStart + leftNum + 1, pEnd, rootIdx + 1, iEnd);
        return root;
    }
}
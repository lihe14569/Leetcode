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
    int[] preorder;
    int[] postorder;
    Map<Integer,Integer> postMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        int n = preorder.length;
        postMap = new HashMap<>();
        for(int i = 0; i < n; i++) postMap.put(postorder[i], i);
        return dfs(0, n - 1, 0, n - 1);
    }
    public TreeNode dfs(int prestart, int preend, int poststart, int postend) {
        if(prestart > preend || poststart > postend) return null;
        if(prestart == preend) return new TreeNode(preorder[prestart]);
        int rootVal = preorder[prestart];
        int leftVal = preorder[prestart + 1];
        int leftIdx = postMap.get(leftVal);
        int leftLen = leftIdx - poststart;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(prestart + 1, prestart + leftLen + 1, poststart, leftIdx);
        root.right = dfs(prestart + leftLen + 2, preend, leftIdx + 1, postend - 1);
        return root;
    }
}
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
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int prev = 0;
        for(int i = list.size()  -1; i >= 0; i--) {
            TreeNode node = list.get(i);
            node.val = node.val + prev;
            prev = node.val;
        }
        return root;
    }
    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
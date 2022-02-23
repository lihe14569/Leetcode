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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if(res.size() == level) {
            res.add(new ArrayList<>());
        }
        if(root == null) return;
        List<Integer> list = res.get(level);
        list.add(root.val);
        if(root.left != null) dfs(root.left, res, level + 1);
        if(root.right != null) dfs(root.right, res, level + 1);
    }
}
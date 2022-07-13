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
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if(root == null) return;
        if(res.size() == depth) {
            res.add(new ArrayList<>());
        }
        List<Integer> curr = res.get(depth);
        curr.add(root.val);
        dfs(root.left, res, depth + 1);
        dfs(root.right, res, depth + 1);
    }
}
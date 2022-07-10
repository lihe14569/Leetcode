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
    public List<String> binaryTreePaths(TreeNode root) {
        //backtrack
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }
    public void dfs(TreeNode root, List<String> path, List<String> res) {
        //base case
        if(root.left == null && root.right == null) {
            path.add(root.val + "");
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val + "");
        if(root.left != null) dfs(root.left, path, res);
        if(root.right != null) dfs(root.right, path, res);
        path.remove(path.size() - 1);
    }
}
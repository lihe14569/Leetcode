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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=  new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            if(root == null) continue;
            res.add(root.val);
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);
        }
        Collections.reverse(res);
        return res;
    }
}
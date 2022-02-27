/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        mapParent(root);
        while(p != null) {
            visited.add(p);
            p = parent.get(p);
        }
        while(q != null) {
            if(visited.contains(q)) return q;
            q = parent.get(q);
        }
        return root;
    }
    public void mapParent(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            parent.put(root.left, root);
            mapParent(root.left);
        }
        if(root.right != null) {
            parent.put(root.right, root);
            mapParent(root.right);
        }
    }
}
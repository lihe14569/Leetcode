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
class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new ArrayDeque<>();
    }
    
    public int next() {
        while(root!= null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        int res = root.val;
        root = root.right;
        return res;
    }
    
    public boolean hasNext() {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
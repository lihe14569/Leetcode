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

    // Approach 1: Flatten Binary Search Tree: Recursive Inorder Traversal
    List<Integer> list = new ArrayList<>();
    int pointer;
    int n;
    
    public void inorder(TreeNode r, List<Integer> arr) {
        if(r == null) return;
        inorder(r.left, arr);
        arr.add(r.val);
        inorder(r.right, arr);
    }
    public BSTIterator(TreeNode root) {
        inorder(root, list);
        n = list.size();
        pointer = -1;
    }
    
    public boolean hasNext() {
        return pointer < n - 1;
    }
    
    public int next() {
        return list.get(++pointer);
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        return list.get(--pointer);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
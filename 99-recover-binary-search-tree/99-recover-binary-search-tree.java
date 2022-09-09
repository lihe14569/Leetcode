class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first= null, second = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            if(root.val < prev.val) {
                if(first == null) {
                    first = prev;
                    second = root;
                } else second = root;
            }
            prev = root;
            root = root.right;
        }
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
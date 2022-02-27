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
    public int widthOfBinaryTree(TreeNode root) {
        //bfs
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        int maxW = 0;
        int currW = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == 0) start = map.get(node);
                if(i == size - 1) end = map.get(node);
                if(node.left != null) {
                    map.put(node.left, 2 * map.get(node));
                    q.offer(node.left);
                }
                if(node.right != null) {
                    map.put(node.right, 2 * map.get(node) + 1);
                    q.offer(node.right);
                }
            }
            currW = end - start + 1;
            maxW = Math.max(maxW, currW);
        }
        return maxW;
    }
}
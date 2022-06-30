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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //bfs
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Map<TreeNode, Integer> nodeToCol = new HashMap<>();
        Map<Integer, List<Integer>> colToNodes = new HashMap<>();
        nodeToCol.put(root, 0);
        int minC = 0, maxC = 0;
        
        while(!q.isEmpty()) {
            int size=  q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int col = nodeToCol.get(node);
                List<Integer> currCol = colToNodes.getOrDefault(col, new ArrayList<>());
                currCol.add(node.val);
                colToNodes.put(col, currCol);
                if(node.left != null) {
                    q.offer(node.left);
                    nodeToCol.put(node.left, col - 1);
                    minC = Math.min(minC, col - 1);
                }
                if(node.right != null) {
                    q.offer(node.right);
                    nodeToCol.put(node.right, col + 1);
                    maxC = Math.max(maxC, col + 1);
                }
            }
        }
        for(int i = minC; i <= maxC; i++) {
            if(colToNodes.containsKey(i)) {
                res.add(colToNodes.get(i));
            }
        }
        return res;
        
    }
}
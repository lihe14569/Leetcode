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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        int left = 0, right = 0;
        //bfs
        Map<Integer, List<Integer>> verticalOrder = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0; i < size; i++) {
                Pair node = q.poll();
                TreeNode curr = node.node;
                int currPos = node.pos;
                if(!verticalOrder.containsKey(currPos)) 
                    verticalOrder.put(currPos, new ArrayList<>());
                verticalOrder.get(currPos).add(curr.val);
                if(curr.left != null) q.offer(new Pair(curr.left, currPos - 1));
                if(curr.right != null) q.offer(new Pair(curr.right, currPos + 1));
                left = Math.min(left, currPos - 1);
                right = Math.max(right, currPos + 1);
            }
        }
        
        for(int i = left; i <= right; i++) {
            List<Integer> lst = verticalOrder.get(i);
            if(lst != null) res.add(lst);
        }
        return res;
    }
    class Pair {
        TreeNode node;
        int pos;
        public Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
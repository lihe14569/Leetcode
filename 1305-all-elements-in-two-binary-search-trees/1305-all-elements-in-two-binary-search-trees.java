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
    public void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //tree to line strucure and then sort
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>(), output = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        Stream.of(list1, list2).forEach(output::addAll);
        Collections.sort(output);
        return output;
    }
   
}
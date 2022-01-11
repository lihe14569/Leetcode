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
    public int sumRootToLeaf(TreeNode root) {
        //backtrack
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, list, sb);
        for(String s: list) {
            System.out.println(s);
        }
        return list.stream().map(str -> Integer.parseInt(str, 2)).collect(Collectors.summingInt(Integer::intValue));
    }
    
    public void dfs(TreeNode root, List<String> list, StringBuilder sb) {
        //base case
        if(root.left == null && root.right == null) {
            int last = sb.length();
            sb.append(root.val);
            list.add(sb.toString());
            sb.deleteCharAt(last);
            return;
        }
        int len =  sb.length();
        sb.append(root.val);
        if(root.left != null) dfs(root.left, list, sb);
        if(root.right != null) dfs(root.right, list, sb);
        sb.deleteCharAt(len);
    }
}
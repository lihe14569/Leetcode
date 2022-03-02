/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(String.valueOf(root.val) + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode dfs2(Queue<String> q, int min, int max) {
        if(q.isEmpty()) return null;
        String s = q.peek();
        int value = Integer.valueOf(s);
        if(value <= min || value >= max) return null;
        TreeNode root = new TreeNode(value);
        q.poll();
        root.left = dfs2(q, min, value);
        root.right = dfs2(q, value, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
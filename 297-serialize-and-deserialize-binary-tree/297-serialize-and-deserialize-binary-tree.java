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
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(String.valueOf(root.val) + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs1(q);
    }
    public TreeNode dfs1(Queue<String> q) {
        String s = q.poll();
        if(s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = dfs1(q);
        root.right = dfs1(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
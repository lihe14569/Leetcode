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
        dfs1(root, sb);
        return sb.toString();
    }
    void dfs1(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(root.val + ",");
        dfs1(root.left, sb);
        dfs1(root.right, sb);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    TreeNode dfs2(Queue<String> q, int min, int max) {
        if(q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.valueOf(s);
        if(val < min || val > max) return null;
        TreeNode node = new TreeNode(val);
        q.poll();
        node.left = dfs2(q, min, val);
        node.right = dfs2(q, val, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
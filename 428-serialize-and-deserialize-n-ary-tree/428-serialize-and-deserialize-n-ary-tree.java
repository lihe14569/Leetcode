/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs1(root, sb);
        return sb.toString();
    }
    void dfs1(Node root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        sb.append(root.children.size() + ",");
        for(Node child : root.children) {
            dfs1(child, sb);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(q);
    }
    Node dfs2(Queue<String> q) {
        String s = q.poll();
        if(s.equals("#")) return null;
        Node node = new Node(Integer.valueOf(s), new ArrayList<>());
        int size = Integer.valueOf(q.poll());
        for(int i = 0; i < size; i++) {
            node.children.add(dfs2(q));
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    public void dfs(Node root, List<List<Integer>> res, int level) {
        if(res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(root.val);
        for(Node node : root.children) {
            dfs(node, res, level + 1);
        }
    }
}
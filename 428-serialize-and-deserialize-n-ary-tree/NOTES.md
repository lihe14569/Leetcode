```
class Codec {
// Encodes a tree to a single string.
public String serialize(Node root) {
List<String> list = new ArrayList<>();
dfs1(root, list);
return String.join(",", list);
}
public void dfs1(Node root, List<String> list) {
//base case
if(root == null) return;
list.add(String.valueOf(root.val));
list.add(String.valueOf(root.children.size()));
for(Node child : root.children) {
dfs1(child, list);
}
}
// Decodes your encoded data to tree.
public Node deserialize(String data) {
if(data.equals("")) return null;
Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
return dfs2(q);
}
public Node dfs2(Queue<String> q) {
String s = q.poll();
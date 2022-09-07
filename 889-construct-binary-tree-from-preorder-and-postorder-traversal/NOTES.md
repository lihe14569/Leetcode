solution:
```
class Solution {
Map<Integer, Integer> map = new HashMap<>();
public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//conner case
if (preorder == null || postorder == null) {
return null;
}
for (int i = 0; i < postorder.length; i++) {
map.put(postorder[i], i);
}
return buildTree(preorder,0, preorder.length - 1, postorder, 0, postorder.length - 1);
}
//
private TreeNode buildTree(int[] preorder, int start1, int end1, int[] postorder, int start2, int end2) {
//base case
if (start1 > end1) {
return null;
}
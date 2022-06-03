ret.left = buildTree(nums, start, mid);
ret.right = buildTree(nums, mid + 1, end);
ret.sum = ret.left.sum + ret.right.sum;
}
return ret;
}
}
void update(int i, int val) {
update(root, i, val);
}
void update(SegmentTreeNode root, int pos, int val) {
if (root.start == root.end) {
root.sum = val;
} else {
int mid = root.start + (root.end - root.start) / 2;
if (pos <= mid) {
update(root.left, pos, val);
} else {
update(root.right, pos, val);
}
root.sum = root.left.sum + root.right.sum;
}
}
​
public int sumRange(int i, int j) {
return sumRange(root, i, j);
}
public int sumRange(SegmentTreeNode root, int start, int end) {
if (root.end == end && root.start == start) {
return root.sum;
} else {
int mid = root.start + (root.end - root.start) / 2;
if (end <= mid) {
return sumRange(root.left, start, end);
} else if (start >= mid+1) {
return sumRange(root.right, start, end);
}  else {
return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
}
}
}
}
```
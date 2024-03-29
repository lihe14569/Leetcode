class NumArray {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
    
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) node.sum = nums[start];
        else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    public void update(SegmentTreeNode root, int index, int val) {
        if(root.start == root.end) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(index <= mid) update(root.left, index, val);
        else update(root.right, index, val);
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
    public int sumRange(SegmentTreeNode root, int left, int right) {
        if(root.start == left && root.end == right) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(right <= mid) {
            return sumRange(root.left, left, right);
        } else if(left >= mid + 1) {
            return sumRange(root.right, left, right);
        } else {
            return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
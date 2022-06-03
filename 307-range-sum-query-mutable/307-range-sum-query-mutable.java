class NumArray {
    class STNode {
        int start, end;
        STNode left, right;
        int sum;
        STNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
    STNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    private STNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        else{
            STNode curr = new STNode(start, end);
            if(start == end) {
                curr.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                curr.left = buildTree(nums, start, mid);
                curr.right = buildTree(nums, mid + 1, end);
                curr.sum = curr.left.sum + curr.right.sum;
            }
            return curr;
        }
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    private void update(STNode node, int index, int val) {
        if(node.start == index && node.end == index) {
            node.sum = val;
            return;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if(index <= mid) {
                update(node.left, index, val);
            } else {
                update(node.right, index, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }
    private int sumRange(STNode root, int left, int right) {
        if(root.start == left && root.end == right){
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start)/ 2;
            if(right <= mid) {
                return sumRange(root.left, left, right);
            } else if(left >= mid + 1) {
                return sumRange(root.right, left, right);
            } else {
                return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
            }
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
else {
return quickselect(nums, l, position - 1, k);
}
}
public int partition(int[] nums, int l, int r) {
int pivotIndex = l + rand.nextInt(r - l + 1);
int pivot = nums[pivotIndex];
swap(nums, pivotIndex, r);
int wall = l;
for(int i = l; i < r; i++) {
if(nums[i] < pivot) {
swap(nums, wall, i);
}
wall++;
}
swap(nums, wall, r);
return wall;
}
public void swap(int[] nums, int l, int r) {
int temp = nums[l];
nums[l] = nums[r];
nums[r] = temp;
}
}
```
​
binary search to find the kth largest
​
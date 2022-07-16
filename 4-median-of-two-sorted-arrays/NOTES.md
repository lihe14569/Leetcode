binary search :注意， m1和m2代表的是从数组中取出的个数，第m1个对应的是m1 - 1 index
```
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
int m = nums1.length, n = nums2.length;
if(m > n) return findMedianSortedArrays(nums2, nums1);
int k = (m + n + 1) / 2;
int l  = 0, r = m; //注意：l,r边界代表的个数，不是index!!!
while(l < r) {
int m1 = (l + r) /2;
int m2 = k - m1;
if(nums1[m1] < nums2[m2 - 1]) {
l = m1 + 1;
} else {
r = m1;
}
}
int m1 = l, m2 = k - l;
int mid1 = m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1]; //不从num1中取元素
int mid2 = m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
int c1 = Math.max(mid1, mid2);
if((m + n)% 2 == 1) return (double)c1;
int mid3 = m1 >= m ? Integer.MAX_VALUE : nums1[m1];
int mid4 = m2 >= n ? Integer.MAX_VALUE : nums2[m2];
int c2 = Math.min(mid3, mid4);
return (double)(c1 + c2) / 2;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int tot = m + n;
        if(tot % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, tot / 2);
            int right = find(nums1, 0, nums2, 0, tot / 2 + 1);
            return (double)(left + right) / 2.0;
        } else {
            return (double) find(nums1, 0, nums2, 0, tot / 2 + 1);
        }
    }
    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if(nums1.length - i > nums2.length - j) return find(nums2, j, nums1, i, k);
        //corner case
        if(k == 1) {
            if(nums1.length == i) return nums2[j];
            //??为什么要求min
            else return Math.min(nums1[i], nums2[j]);
        }
        //特判的情况，nums1是空
        if(nums1.length == i) return nums2[j + k - 1];
        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if(nums1[si - 1] < nums2[sj - 1]) {
            return find(nums1, si, nums2, j, k - (si - i));
        } else {
            return find(nums1, i, nums2, sj, k - (sj - j));
        }
    }
}
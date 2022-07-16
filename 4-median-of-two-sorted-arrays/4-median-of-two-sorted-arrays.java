class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        int m = n1.length, n = n2.length;
        if(m > n) return findMedianSortedArrays(n2, n1);
        int k = (m + n +1) / 2;
        int l = 0, r = m;
        while(l < r) {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if(n1[m1] < n2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }
        int m1 = l, m2 = k - l;
        int mid1 = m1 == 0 ? Integer.MIN_VALUE : n1[m1 - 1];
        int mid2 = m2 == 0 ? Integer.MIN_VALUE : n2[m2 - 1];
        
        double c1 = (double)Math.max(mid1, mid2);
        if((m + n) % 2 == 1) return c1;
        
        int mid3 = m1 == m ? Integer.MAX_VALUE : n1[m1];
        int mid4 = m2 == n ? Integer.MAX_VALUE : n2[m2];
        
        double c2 = (double) Math.min(mid3, mid4);
        return (c1 + c2) / 2.0;
    }
}
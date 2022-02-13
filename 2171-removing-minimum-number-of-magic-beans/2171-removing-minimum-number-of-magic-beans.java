class Solution {
    public long minimumRemoval(int[] beans) {
        long sum = 0;
        Arrays.sort(beans);
        long max = 0, n = beans.length;
        for(int i = 0; i < n; i++) {
            sum += (long) beans[i];
            max = Math.max(max, (long)beans[i] * (n - i));
        }
        return sum - max;
    }
}